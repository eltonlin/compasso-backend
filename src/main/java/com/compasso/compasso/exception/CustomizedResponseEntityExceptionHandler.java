package com.compasso.compasso.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final String INTERNAL_ERROR = "An internal error has ocurred";

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomizedResponseException> handleAllExceptions() {
		CustomizedResponseException customizedResponseException = new CustomizedResponseException(INTERNAL_ERROR,
				HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(customizedResponseException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<CustomizedResponseException> handleBusinessException(BusinessException ex) {
		CustomizedResponseException customizedResponseException = new CustomizedResponseException(ex.getMessage(),
				HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(customizedResponseException, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		CustomizedResponseException exceptionResponse = new CustomizedResponseException(
				ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
