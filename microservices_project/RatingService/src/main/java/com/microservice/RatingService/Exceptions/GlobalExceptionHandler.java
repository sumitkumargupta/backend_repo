package com.microservice.RatingService.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RatingNotFoundException.class)
	public ResponseEntity<Map<String, Object>> ratingNotFoundExceptionHandler(RatingNotFoundException ex){
		Map<String, Object> map = new HashMap<>();
		map.put("Reason", ex.getMessage());
		map.put("Status", ex.getHttpStatus());
		map.put("Status Code", ex.getHttpStatus().value());
		return ResponseEntity.status(ex.getHttpStatus()).body(map);
	}
}
