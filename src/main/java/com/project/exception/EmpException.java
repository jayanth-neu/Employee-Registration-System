package com.project.exception;

public class EmpException extends Exception{
	public EmpException(String message)
	{
		super(message);
	}
	
	public EmpException(String message, Throwable cause)
	{
		super(message,cause);
	}
}