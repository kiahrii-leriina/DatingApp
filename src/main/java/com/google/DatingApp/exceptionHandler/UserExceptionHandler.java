package com.google.DatingApp.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.DatingApp.exceptionclasses.DuplicateEmailException;
import com.google.DatingApp.exceptionclasses.InvalidIDException;
import com.google.DatingApp.exceptionclasses.InvalidOTPException;
import com.google.DatingApp.exceptionclasses.NoUserFoundException;
import com.google.DatingApp.responseStructure.ResponseStructure;

@RestControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(DuplicateEmailException.class)
	public ResponseStructure<String> duplicateEmailExceptionHandler(DuplicateEmailException e){
		
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Account already exist ");	
		rs.setBody(e.getMessage());	
		return rs;
	}
	
	@ExceptionHandler(InvalidIDException.class)
	public ResponseStructure<String> invalidIDException(InvalidIDException e){
		
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Invalid id");
		rs.setBody(e.getMessage());
		return rs;
	}
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseStructure<String> noUserFoundException(NoUserFoundException e){
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Invalid User Name");
		rs.setBody(e.getMessage());
		return rs;
	}
	@ExceptionHandler(InvalidOTPException.class)
	public ResponseStructure<String> invalidOtpException(InvalidOTPException e){
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatus(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Invalid Otp");
		rs.setBody(e.getMessage());
		return rs;
	}
	
	

}
