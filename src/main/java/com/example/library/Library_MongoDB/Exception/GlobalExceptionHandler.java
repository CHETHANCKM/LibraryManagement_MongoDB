package com.example.library.Library_MongoDB.Exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request)
	{
		ErrorClass errorClass = new ErrorClass(new Date(0), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorClass, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceAlreadyExists.class)
	public ResponseEntity<?> handleResourceAlreadyExists(ResourceAlreadyExists exception, WebRequest request)
	{
		ErrorClass errorClass = new ErrorClass(new Date(0), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorClass, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
