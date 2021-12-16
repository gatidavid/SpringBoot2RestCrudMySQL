package com.fount.david.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fount.david.error.ErrorType;
import com.fount.david.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorType> handleEmployeeNotFound(@RequestBody EmployeeNotFoundException enfe){
		
		return new ResponseEntity<ErrorType>(new ErrorType(
											new Date().toString(), 
											"EMPLOYEE",
											enfe.getMessage(), 
											"PROCESSING ISSUE"),
											HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
