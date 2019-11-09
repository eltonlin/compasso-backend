package com.compasso.compasso.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7436262980608410487L;

	public BusinessException(String exception) {
		super(exception);
	}
}
