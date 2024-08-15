package com.microservices.UsersService.Services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.UsersService.Entities.Hotel;
import com.microservices.UsersService.Entities.Rating;
import com.microservices.UsersService.Entities.User;
import com.microservices.UsersService.Exceptions.UserNotFoundExcetpion;
import com.microservices.UsersService.Repository.UserRepository;


@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> user = userRepo.findAll();
		user.forEach((use)-> {
			use = getUserById(use.getId());
		});
		return user;
	}
	
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		//Get user detail with id
		User user = userRepo.findById(id).orElseThrow(()-> new UserNotFoundExcetpion("User Not Found with this id: "+ id, HttpStatus.NOT_FOUND));
		//Get Rating detail by id
		Rating[] ratingArray = restTemplate.getForObject("http://RATING-SERVICE/ratingservice/user/rating/" + user.getId(), Rating[].class);
		List<Rating> ratings = Arrays.asList(ratingArray);
		  ratings.forEach(rating -> { Hotel hotel =
		  restTemplate.getForObject("http://HOTEL-SERVICE/hotel/gethotel/" +
		  rating.getHotelId(), Hotel.class); rating.setHotel(hotel); });
		 
		user.setRatings(ratings);
		return user;
	}


	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		User newUser = userRepo.save(user);
		user.getRatings().forEach((rating)->{
			HttpEntity<Rating> entity = new HttpEntity<Rating>(rating, httpHeaders);
			if(rating.getHotel() != null) {
				HttpEntity<Hotel> hotelEntity = new HttpEntity<Hotel>(rating.getHotel(), httpHeaders);
				Hotel hotel = restTemplate.postForObject("http://HOTEL-SERVICE/hotel/addhotel" ,hotelEntity , Hotel.class); 
				rating.setHotelId(hotel.getId());
				rating.setUserId(newUser.getId());
				rating.setHotel(hotel);
			}
			rating = restTemplate.postForObject("http://RATING-SERVICE/ratingservice/rating", entity, Rating.class);
		});
		return newUser;
	}

	@Override
	public User updateUser(Integer userId, User user) {
		// TODO Auto-generated method stub
		Optional<User> optionalUser = userRepo.findById(userId);
		if(optionalUser.isEmpty())
			throw new UserNotFoundExcetpion("User Not found with this id: "+ userId, HttpStatus.NOT_FOUND);
		User oldUser = optionalUser.get();
		oldUser.setAddress(user.getAddress());
		oldUser.setAge(user.getAge());
		oldUser.setGender(user.getGender());
		oldUser.setName(user.getName());
		oldUser.setOccupation(user.getOccupation());
		user.getRatings().forEach((rating)->{
			//HttpEntity<Rating> entity = new HttpEntity<Rating>(rating, httpHeaders);
			if(rating.getHotel() != null) {
				Hotel hotel = restTemplate.postForObject("http://HOTEL-SERVICE/hotel/addhotel" ,rating.getHotel() , Hotel.class); 
				rating.setHotel(hotel);
			}
			rating = restTemplate.postForObject("http://RATING-SERVICE/ratingservice/rating", rating, Rating.class);
		});
		oldUser.setRatings(user.getRatings());
		User updatingUser = userRepo.save(oldUser);
		return updatingUser;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		//User user = userRepo.findById(userId).orElseThrow(()-> new UserNotFoundExcetpion("User not found with this id: " +  userId, HttpStatus.NOT_FOUND));
		User user = getUserById(userId);
		user.getRatings().forEach((rating)->{
			//HttpEntity<Rating> entity = new HttpEntity<Rating>(rating, httpHeaders);
			restTemplate.delete("http://RATING-SERVICE/ratingservice/rating/" + rating.getRatingId());
		});
		userRepo.delete(user);
	}
	
}
