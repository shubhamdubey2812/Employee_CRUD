package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	public ResourceNotFoundException(String msg,HttpStatus httpStatus) {
		super(msg);
		this.httpStatus=httpStatus;
	}
	public HttpStatus getStatus() {
		return httpStatus;
	}
}
