package com.legacymed.med.hub.project.config;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class RequestHandlerManagerExceptions {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> entityNotFoundException() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        Map<String, String> errorMap = errors.stream()
                                            .collect(Collectors.toMap(
                                                FieldError::getField,
                                                FieldError::getDefaultMessage
                                            ));
        return ResponseEntity.badRequest().body(errorMap);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, String> errors = new HashMap<>();
        if (ex.getCause() instanceof SQLIntegrityConstraintViolationException) {
            errors.put("message", "Duplicate entry. This record violates a unique constraint.");
        } else {
            errors.put("message", "Data integrity violation.");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errors);
    }
}