package br.com.aguiabranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalException extends Exception{

	private static final long serialVersionUID = -8393858301493372973L;
	
	public InternalException(String message) {
		super(message);
	}
	
	public InternalException(Exception e) {
		super(e);
	}
}
