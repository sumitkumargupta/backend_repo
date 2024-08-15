package com.microservice.RatingService.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.RatingService.Entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer>{

	public List<Rating> findByUserId(Integer id);
	
	public List<Rating> findByHotelId(Integer id);
}
