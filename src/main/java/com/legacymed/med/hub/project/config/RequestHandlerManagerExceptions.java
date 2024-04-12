package com.legacymed.med.hub.project.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RequestHandlerManagerExceptions {

	 @ExceptionHandler(EntityNotFoundException.class)
	    public ResponseEntity<Void> entityNotFoundException() {
	        return ResponseEntity.notFound().build();
	    }
}
