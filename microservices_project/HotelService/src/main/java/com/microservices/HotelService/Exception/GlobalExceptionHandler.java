package com.microservices.HotelService.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.HotelService.PayloadAndResponse.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ApiResponse> hotelNotFoundExceptionHandler(HotelNotFoundException ex) {
		ApiResponse apiResponse = new ApiResponse(ex.getMessage() ,false, ex.getHttpStatus(),ex.getHttpStatus().value());
		return new ResponseEntity<ApiResponse>(apiResponse, ex.getHttpStatus());
	}  

}
