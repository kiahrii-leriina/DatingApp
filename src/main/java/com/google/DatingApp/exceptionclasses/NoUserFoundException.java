package com.google.DatingApp.exceptionclasses;

public class NoUserFoundException extends RuntimeException{
	private String message;
	NoUserFoundException(){}
	public NoUserFoundException(String message){
		this.message = message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
