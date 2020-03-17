package com.capgemeini.springrest.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemeini.springrest.beans.EmployeeResponse;
import com.capgemeini.springrest.exception.EmployeeException;

@RestControllerAdvice
public class MyRestControllerAdvice {
	@ExceptionHandler
	public EmployeeResponse myExceptionHandler(EmployeeException employeeException) {
		EmployeeResponse response = new EmployeeResponse();
		response.setError(true);
		response.setMessage(employeeException.getMessage());
		return response;
	}
}
