package com.empstatus.globalexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class ErrorResponse{

	public ErrorResponse(String status, HttpStatus httpstatus, String message, LocalDateTime localDateTime) {
		super();
		this.status = status;
		this.httpstatus = httpstatus;
		this.message = message;
		this.timestamp = localDateTime;
	}
	String status;
	HttpStatus httpstatus;
	String message;
	LocalDateTime timestamp=LocalDateTime.now() ;
	public String getStatus() {
		return status;
	}
	public HttpStatus getHttpstatus() {
		return httpstatus;
	}
	public String getMessage() {
		return message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setHttpstatus(HttpStatus httpstatus) {
		this.httpstatus = httpstatus;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	
	
}
