package com.microservices.HotelService.Exception;

import org.springframework.http.HttpStatus;

public class HotelNotFoundException extends RuntimeException {

	private Integer hotelId;
	private String message;
	private HttpStatus httpStatus;
	
	public HotelNotFoundException(String message, Integer hotelId, HttpStatus httpStatus) {
		// TODO Auto-generated constructor stub
		super(message + " ,Id: " + hotelId + " , Status: " + httpStatus);
		this.hotelId = hotelId;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
