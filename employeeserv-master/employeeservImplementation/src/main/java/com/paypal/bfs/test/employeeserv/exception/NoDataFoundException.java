package com.paypal.bfs.test.employeeserv.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 4539879263263314184L;
	private static final String DEFAULT_MESSAGE = "No data found for given arguments";

	public NoDataFoundException(String message){
		super(message);
	}
	
	public NoDataFoundException(){
		super(DEFAULT_MESSAGE);
	}
	
	public NoDataFoundException(Throwable cause){
		super(cause);
	}
	
	public NoDataFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

