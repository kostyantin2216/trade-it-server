package com.charlieaffs.rest.exceptions;

public class IllegalServiceQueryException extends IllegalArgumentException {
	private static final long serialVersionUID = 896206411894274016L;

	public IllegalServiceQueryException(String message) {
		super(message);
	}
	
	public IllegalServiceQueryException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
