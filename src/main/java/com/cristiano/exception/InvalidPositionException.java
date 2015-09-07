package com.cristiano.exception;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPositionException() {
		super();
	}
	
	public InvalidPositionException(String msg){
		super(msg);
	}
}
