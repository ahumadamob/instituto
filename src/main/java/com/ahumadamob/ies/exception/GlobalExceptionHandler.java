package com.ahumadamob.ies.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ahumadamob.ies.dto.ResponseDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // HTTP 400
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseDTO<?>> handleValidationExceptions(ConstraintViolationException ex) {
        ResponseDTO<?> dto = new ResponseDTO<>(HttpStatus.BAD_REQUEST.value());
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
        	dto.addError(violation.getPropertyPath().toString(), violation.getMessage());
        }        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
    }
    
    @ResponseStatus(HttpStatus.CONFLICT) // HTTP 409
    @ExceptionHandler(DuplicateDniException.class)
    public ResponseEntity<ResponseDTO<?>> handleDuplicateDniException(DuplicateDniException ex) {
        ResponseDTO<?> dto = new ResponseDTO<>(HttpStatus.CONFLICT.value());
        dto.addError("dni", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dto);
    }  
    
  
}

