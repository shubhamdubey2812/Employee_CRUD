package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex
			,HttpServletRequest request){
			ErrorResponse errorRespons=new ErrorResponse();
			errorRespons.setMessage(ex.getMessage());
			errorRespons.setPath(request.getRequestURI());
			errorRespons.setStatus(ex.getStatus().value());
			errorRespons.setTimestamp(LocalDateTime.now());
			return new ResponseEntity<>(errorRespons, ex.getStatus());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobalException(
	        Exception ex,
	        HttpServletRequest request){
	    ErrorResponse error = new ErrorResponse(
	            ex.getMessage(),
	            500,
	            LocalDateTime.now(),
	            request.getRequestURI()
	    );
	    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
