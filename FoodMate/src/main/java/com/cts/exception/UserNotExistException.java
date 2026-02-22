package com.cts.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class UserNotExistException extends RuntimeException{
	
	private String message;
	
	public UserNotExistException(String message) {
		super();
		this.message = message;
	}
	
	

}
