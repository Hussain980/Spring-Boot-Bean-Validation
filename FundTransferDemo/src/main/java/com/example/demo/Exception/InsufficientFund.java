package com.example.demo.Exception;

public class InsufficientFund extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficientFund(String message) {
		super(message);
	}

}
