package com.example.demo.Exception;

public class AccountNumberAlreadyExist extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public AccountNumberAlreadyExist(String message) {
		super(message);
	}
}
