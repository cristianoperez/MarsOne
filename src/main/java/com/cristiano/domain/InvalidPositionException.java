package com.cristiano.domain;

public class InvalidPositionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPositionException() {
		super();
	}
	
	public InvalidPositionException(String msg){
		super(msg);
	}
}
