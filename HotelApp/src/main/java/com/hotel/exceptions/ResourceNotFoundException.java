package com.hotel.exceptions;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("Resource not found..");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
