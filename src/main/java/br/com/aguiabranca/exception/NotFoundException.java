package br.com.aguiabranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{

	private static final long serialVersionUID = 5607063384764831668L;
	
	public NotFoundException(String message) {
		super(message);
	}
	
}
