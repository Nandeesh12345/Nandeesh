package com.example.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.BusinessException;
import com.example.demo.exception.EmptyInputException;
import com.example.demo.exception.NoRecordException;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input field is Empty, Please look into it",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementExcetion(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("No value present in DB, pLease change your request",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException httpRequestMethodNotSupported){
		return new ResponseEntity<Object>("please change the method type",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException){
		return new ResponseEntity<String>("No value present in DB, pLease change your request",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handleBusinessException(BusinessException businessException){
		return new ResponseEntity<String>("No matching value present in DB to delete, please change your request",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(NoRecordException.class)
	public ResponseEntity<String> handleNoRecordException(NoRecordException noRecordException){
		return new ResponseEntity<String>("No Records Found",HttpStatus.NOT_FOUND);
	}
}

