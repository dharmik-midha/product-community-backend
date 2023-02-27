package com.nagarro.controller;

import javax.validation.ConstraintViolation; 
import javax.validation.ConstraintViolationException;

import com.nagarro.exception.PostNotFoundException;
import com.nagarro.exception.ProductNotFoundException;
import com.nagarro.exception.UserAlreadyExistException;
import com.nagarro.exception.UserNotFoundException;
import com.nagarro.exception.UserUnauthorizedException;
import com.nagarro.utils.ResponseHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

@RestControllerAdvice
public class ControllerAdvicer {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstaintViolatoinException(final ConstraintViolationException e) {
		String errorMessage = String.join(", ",
				e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList());
		return ResponseHandler.generateResponse(errorMessage, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<Object> handleException(UserAlreadyExistException e) {
		return ResponseHandler.generateResponse("User with email already Exist!", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleException(UserUnauthorizedException e){
		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.UNAUTHORIZED);
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleException(UserNotFoundException e){
		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleException(ProductNotFoundException e){
		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleException(PostNotFoundException e){
		return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleException(InternalServerError e){
		return ResponseHandler.generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleException(Exception e){
		return ResponseHandler.generateResponse("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}