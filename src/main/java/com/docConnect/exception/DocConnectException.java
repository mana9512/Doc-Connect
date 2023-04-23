package com.docConnect.exception;

public class DocConnectException extends Exception {
	private static final long serialVersionUID = 1L;

	public DocConnectException(String message)
	{
		super(message);
	}
	
	public DocConnectException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
