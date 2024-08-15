package com.microservices.UsersService.Exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundExcetpion extends RuntimeException {
	
	private String message;
	private HttpStatus httpStatus;
	
	public UserNotFoundExcetpion(String message, HttpStatus httpStatus) {
		super(message + " with status : " + httpStatus);
		this.message = message;
		this.httpStatus = httpStatus;
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
