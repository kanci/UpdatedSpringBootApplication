package com.example.myspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MethodArgumentNotValidException extends IllegalArgumentException  {
	private static final long serialVersionUID = 1L;
	public MethodArgumentNotValidException() {
		
	}

}

