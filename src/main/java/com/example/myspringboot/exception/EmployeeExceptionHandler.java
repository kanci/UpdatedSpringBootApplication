package com.example.myspringboot.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//this class has multiple exceptions

@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler (value= {EmployeeNotFoundException.class})
	public ResponseEntity<Object> handleEmployeeRequestException(EmployeeNotFoundException e) {

		//create payload containing exception details
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		
		EmployeeException employeeExcep = new EmployeeException(
				e.getMessage(),
				badRequest,
				ZonedDateTime.now(ZoneId.of("Z"))
				);

		//return response entity
		return new ResponseEntity<>(employeeExcep, badRequest);
	}
}
