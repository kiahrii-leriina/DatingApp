package com.google.DatingApp.exceptionclasses;

public class InvalidIDException extends RuntimeException{
	
	private String message;
	
	InvalidIDException(){}
	public InvalidIDException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
