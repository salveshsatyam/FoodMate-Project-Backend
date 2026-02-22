package com.cts.exception;

public class UserAlreadyExixtsException extends Exception {
	
	private String message;

	public UserAlreadyExixtsException(String message) {
		this.message = message;
	}

}
