package com.microservices.UsersService.Entities;

public class Rating {

	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer rate;
	private String feedback;
	private Hotel hotel;
	
	public Rating() {
		
	}
	
	public Rating(Integer ratingId, Integer userId, Integer hotelId, Integer rate, String feedback) {
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rate = rate;
		this.feedback = feedback;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
	
	
}
