package com.charlieaffs.rest.exceptions;

public class IllegalQueryValueException extends IllegalServiceQueryException {
	private static final long serialVersionUID = 6752751891453936051L;

	public IllegalQueryValueException(String message) {
		super(message);
	}
	
	public IllegalQueryValueException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
