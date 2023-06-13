package com.thiagoferraz.mychess.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MoveNotAllowedException.class)
	public ResponseEntity<StandardError> moveNotAllowed(MoveNotAllowedException e, HttpServletRequest httpServletRequest) {
		StandardError error = new StandardError(HttpStatus.NOT_ACCEPTABLE.value(), e.getMessage(),
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {
		ValidationError validation = new ValidationError(HttpStatus.BAD_REQUEST.value(), e.getMessage(),
				System.currentTimeMillis());
		
		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			validation.addError(error.getField(), error.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validation);
	}	

}
