package com.microservice.RatingService.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.RatingService.Entities.Rating;
import com.microservice.RatingService.Exceptions.RatingNotFoundException;
import com.microservice.RatingService.Repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public List<Rating> getRatings() {
		// TODO Auto-generated method stub
		List<Rating> ratings = ratingRepo.findAll();
		return ratings;
	}
	
	@Override
	public Rating getRatingById(Integer id) {
		// TODO Auto-generated method stub
		Rating rating = ratingRepo.findById(id).orElseThrow(()-> new RatingNotFoundException("Rating Not Found with this id : " + id, HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value()));
		return rating;
	}
	
	@Override
	public List<Rating> getRatingByUserId(Integer id) {
		// TODO Auto-generated method stub
		List<Rating> rating = ratingRepo.findByUserId(id);
		return rating;
	}

	@Override
	public List<Rating> getRatingByHoteld(Integer id) {
		// TODO Auto-generated method stub
		List<Rating> rating = ratingRepo.findByHotelId(id);
		return rating;
	}

	@Override
	public Rating addRating(Rating rating) {
		// TODO Auto-generated method stub
		Rating newRate = ratingRepo.save(rating);
		return newRate;
	}

	@Override
	public Rating updateRating(Integer ratingId, Rating rating) {
		// TODO Auto-generated method stub
		Rating newRating = ratingRepo.findById(ratingId).orElseThrow(()-> new RatingNotFoundException("Rating Not found with this id:" + ratingId + " to Update.",HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value()));
		newRating.setFeedback(rating.getFeedback());
		newRating.setHotelId(rating.getHotelId());
		newRating.setRate(rating.getRate());
		newRating.setUserId(rating.getUserId());
		 newRating = ratingRepo.save(newRating);
		return newRating;
	}

	@Override
	public void deleteRating(Integer ratingId) {
		// TODO Auto-generated method stub
		Rating ratingToDelete = ratingRepo.findById(ratingId).orElseThrow(()-> new RatingNotFoundException("Rating Not found with this id:" + ratingId + " to Update.",HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND.value()));
		ratingRepo.delete(ratingToDelete);
	}

}
