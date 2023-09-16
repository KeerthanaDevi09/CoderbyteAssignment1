package com.finzly.fxtrading.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;

public class CurrencyPairNotValidException extends RuntimeException{
	
	public CurrencyPairNotValidException(String message)
	{
		super(message);
	}
}
