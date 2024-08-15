package com.microservice.RatingService.Payload;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private String message;
	private Boolean success;
	private HttpStatus httpStatus;
	private Integer ratingId;
	
	public ApiResponse(String message, Boolean success, HttpStatus httpStatus) {
		this.message = message;
		this.success = success;
		this.httpStatus = httpStatus;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Integer getRatingId() {
		return ratingId;
	}
	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}
	
	
	
}
