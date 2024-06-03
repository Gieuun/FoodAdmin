package com.sds.foodadmin.exception;

public class ApiLoadException extends RuntimeException{
	
	public ApiLoadException(String msg) {
		super(msg);
	}
	public ApiLoadException(String msg, Throwable e) {
		super(msg, e);
	}
	public ApiLoadException(Throwable e) {
		super(e);
	}
	
}