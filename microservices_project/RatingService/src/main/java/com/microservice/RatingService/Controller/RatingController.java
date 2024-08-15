package com.microservice.RatingService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.RatingService.Entities.Rating;
import com.microservice.RatingService.Payload.ApiResponse;
import com.microservice.RatingService.Services.RatingService;

@RestController
@RequestMapping("/ratingservice")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(value="/ratings", method = RequestMethod.GET)
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = ratingService.getRatings();
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@RequestMapping(value="/rating", method=RequestMethod.POST)
	public ResponseEntity<Rating> giveRating(@RequestBody Rating rating){
		Rating newRating =  ratingService.addRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(newRating);	
	}
	
	@RequestMapping(value="/rating/{id}", method=RequestMethod.GET)
	public ResponseEntity<Rating> getRatingById(@PathVariable("id") Integer raringId){
		Rating rating = ratingService.getRatingById(raringId);
		return ResponseEntity.status(HttpStatus.OK).body(rating);
	}
	
	@RequestMapping(value="/user/rating/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") Integer userId){
		List<Rating> ratings = ratingService.getRatingByUserId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@RequestMapping(value="/hotel/rating/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") Integer hotelId){
		List<Rating> ratings = ratingService.getRatingByHoteld(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(ratings);
	}
	
	@RequestMapping(value="/rating/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Rating> updateRating(@PathVariable("id") Integer ratingId ,@RequestBody Rating rating){
		Rating updatedRating = ratingService.updateRating(ratingId, rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedRating);
	}
	
	@RequestMapping(value="/rating/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> updateRating(@PathVariable("id") Integer ratingId){
		ratingService.deleteRating(ratingId);
		ApiResponse apiResponse = new ApiResponse("Deleted Successfully.", true, HttpStatus.OK);
		return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
	}

	
}
