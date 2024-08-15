package com.microservices.UsersService.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservices.UsersService.PayloadAndResponse.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundExcetpion.class)
	public ResponseEntity<ApiResponse> userNotFoundExceptionHandler(UserNotFoundExcetpion ex){
		ApiResponse apiResponse = new ApiResponse(false, ex.getMessage(), ex.getHttpStatus());
		apiResponse.setStatusCode(ex.getHttpStatus().value());
		return ResponseEntity.ok().body(apiResponse);
	}
}
