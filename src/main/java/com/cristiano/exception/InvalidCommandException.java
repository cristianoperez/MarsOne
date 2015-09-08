package com.cristiano.exception;

public class InvalidCommandException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidCommandException() {
		super();
	}
	
	public InvalidCommandException(String msg) {
		super(msg);
	}

}
