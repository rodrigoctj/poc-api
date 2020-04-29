package br.com.aguiabranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{

	private static final long serialVersionUID = -8393858301493372973L;
	
	public BadRequestException(String message) {
		super(message);
	}
	
}
