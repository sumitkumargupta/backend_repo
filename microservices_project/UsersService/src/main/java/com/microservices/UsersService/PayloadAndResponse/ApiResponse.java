package com.microservices.UsersService.PayloadAndResponse;

import org.springframework.http.HttpStatus;

public class ApiResponse {

	private Boolean success;
	private String message;
	private HttpStatus httpStatus;
	private Integer statusCode;

	public ApiResponse(Boolean success, String message, HttpStatus httpStatus) {
		this.success = success;
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
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

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	
}
