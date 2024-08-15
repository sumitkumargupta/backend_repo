package com.microservice.RatingService.Services;

import java.util.List;

import com.microservice.RatingService.Entities.Rating;

public interface RatingService {

	public List<Rating> getRatings();
	
	public Rating getRatingById(Integer id);
	
	public List<Rating> getRatingByUserId(Integer id);
	
	public List<Rating> getRatingByHoteld(Integer id);
	
	public Rating addRating(Rating rating);
	
	public Rating updateRating(Integer ratingId, Rating rating);
	
	public void deleteRating(Integer ratingId);
}
