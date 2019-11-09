package com.compasso.compasso.exception;

public class CustomizedResponseException {
	
	private String errorMessage; 
	private String statusCode;
	
	public CustomizedResponseException(String errorMessage, String statusCode) {
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	
}
