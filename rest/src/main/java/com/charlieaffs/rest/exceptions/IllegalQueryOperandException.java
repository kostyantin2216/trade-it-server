package com.charlieaffs.rest.exceptions;

public class IllegalQueryOperandException extends IllegalServiceQueryException {
	private static final long serialVersionUID = 4180510503957786618L;
	
	public IllegalQueryOperandException(String message) {
		super(message);
	}

}
