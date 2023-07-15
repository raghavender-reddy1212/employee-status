package com.empstatus.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Constants {
	
	@Value("${StatusCode400}")
	public  String StatusCode400;
	
	@PostConstruct
	public void message() {
		System.out.println("I am Message" + StatusCode400);
	}

	public String getStatusCode400() {
		return StatusCode400;
	}

}
