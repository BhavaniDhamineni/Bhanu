package com.example.RectCrudDemo.Exception;

public class InvalidProductIDException extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidProductIDException(String msg) {
		super(msg);
	}
}
