package com.customer.Exception;


@SuppressWarnings("serial")
public class CustomerException extends RuntimeException{
	public CustomerException()
	{
		
	}
	public CustomerException(String message)
	{
		super(message);
	}

}
