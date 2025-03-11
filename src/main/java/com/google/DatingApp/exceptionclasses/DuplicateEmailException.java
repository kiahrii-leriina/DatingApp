package com.google.DatingApp.exceptionclasses;

//import lombok.AllArgsConstructor;
//
//import lombok.NoArgsConstructor;

//@NoArgsConstructor
//@AllArgsConstructor

public class DuplicateEmailException extends RuntimeException{
	
	
//extends thorwable will give compile time error
	private String message;
	
	DuplicateEmailException(){}
	
	public DuplicateEmailException(String message){
		this.message = message;
	}
	
	
	@Override
	public String getMessage() {
		return this.message;
	}
	
	
}