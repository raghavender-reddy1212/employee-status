package com.empstatus.globalexception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ne) {
		ErrorResponse errorResponse=new ErrorResponse("400",HttpStatus.BAD_REQUEST,ne.getMessage(),LocalDateTime.now());
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	

}
