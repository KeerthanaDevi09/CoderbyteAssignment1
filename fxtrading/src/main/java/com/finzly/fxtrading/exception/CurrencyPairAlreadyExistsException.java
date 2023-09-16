package com.finzly.fxtrading.exception;

public class CurrencyPairAlreadyExistsException extends RuntimeException{
	
	public CurrencyPairAlreadyExistsException(String message)
	{
		super(message);
	}

}
