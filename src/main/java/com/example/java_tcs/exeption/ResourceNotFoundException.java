package com.example.java_tcs.exeption;

public class ResourceNotFoundException extends Exception  {

	private static final long serialVersionUID = 1L;
	
	
	
	public ResourceNotFoundException (String message) {
		
		super(message);
	}
}
