package com.onerivet.userdetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onerivet.userdetails.models.response.GenericResponse;

public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<GenericResponse<?>> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {

		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());

		return new ResponseEntity<>(genericResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<GenericResponse<?>> methodArgumentNotValidException(MethodArgumentNotValidException exception){
		GenericResponse<?> genericResponse = new GenericResponse<>(null, exception.getMessage());
		return new ResponseEntity<>(genericResponse,HttpStatus.BAD_GATEWAY);
	}
	
	
}
