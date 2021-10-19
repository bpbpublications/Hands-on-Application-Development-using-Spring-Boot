package com.bpb.publications.authors.advice;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bpb.publications.authors.exception.ErrorMessage;
import com.bpb.publications.authors.exception.NoRecordsException;

@ControllerAdvice
@Component
public class AppControllerAdvice {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationExceptions(ConstraintViolationException ex) {
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		return new ResponseEntity<>(new ErrorMessage(constraintViolations.stream()
				.map(constraintViolation -> constraintViolation.getMessage()).collect(Collectors.toList()).get(0)),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoRecordsException.class)
	public ResponseEntity<?> handleNoRecordsException(NoRecordsException ex) {
		return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.NOT_FOUND);
		// for restricting JSON Response
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(new ErrorMessage(ex.getMessage()));  
	}
}
