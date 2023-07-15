package com.empstatus.globalexception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.empstatus.utility.Constants;

@ControllerAdvice
public class ErrorAdvice {
	
	@Autowired
	public Constants constants;
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ne) {
		ErrorResponse errorResponse=new ErrorResponse(constants.getStatusCode400(),HttpStatus.BAD_REQUEST,ne.getMessage(),LocalDateTime.now());
		System.out.println("Test Execution");
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
		
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErrorResponse> handleInvalidArgument(MethodArgumentNotValidException ex) {
	        // Customize the error response message
		ErrorResponse errorResponse=new ErrorResponse(constants.getStatusCode400(),HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDateTime.now());

	        // Return the customized error response with an appropriate HTTP status code
		return new ResponseEntity<ErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	    }
	
	
	

}
