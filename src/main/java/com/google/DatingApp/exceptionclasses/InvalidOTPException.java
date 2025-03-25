package com.google.DatingApp.exceptionclasses;

public class InvalidOTPException extends RuntimeException{
	
	private String message;
	public InvalidOTPException() {}
	
	public InvalidOTPException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}

}
