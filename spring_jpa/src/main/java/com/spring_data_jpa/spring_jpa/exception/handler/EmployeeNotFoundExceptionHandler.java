package com.spring_data_jpa.spring_jpa.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring_data_jpa.spring_jpa.exception.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeNotFoundExceptionHandler 
{
	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException ee)
	{
		return new ResponseEntity<Object>("Employee Not Found !!",HttpStatus.NOT_FOUND);
	}
}