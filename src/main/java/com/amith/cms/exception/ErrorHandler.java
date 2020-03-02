package com.amith.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ChannelNotFoundException.class)
	public ResponseEntity<ApplicationError> handleChannelNotFoundException(
			ChannelNotFoundException exception, WebRequest webRequest) {
		ApplicationError applicationError = new ApplicationError();
		applicationError.setCode(101);
		applicationError.setMessage(exception.getMessage());
		return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNameExistsException.class)
	public ResponseEntity<ApplicationError> handleUserNameExistsException(
			UserNameExistsException exception, WebRequest webRequest) {
		ApplicationError applicationError = new ApplicationError();
		applicationError.setCode(101);
		applicationError.setMessage(exception.getMessage());
		return new ResponseEntity<>(applicationError, HttpStatus.CONFLICT);
	}
}
