package com.microservices.HotelService.PayloadAndResponse;

import org.springframework.http.HttpStatus;

public class ApiResponse {
	private String message;
	private Boolean success;
	private HttpStatus httpStatus;
	private Integer httpStatusCode;
	
	public ApiResponse(String message, Boolean success, HttpStatus httpStatus, Integer httpStatusCode) {
		this.message = message;
		this.success = success;
		this.httpStatus = httpStatus;
		this.httpStatusCode = httpStatusCode;
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

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}
	
	
	
	
}
