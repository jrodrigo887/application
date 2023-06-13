package com.estudy.application.resources.execptinos;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudy.application.services.exceptions.DatabaseException;
import com.estudy.application.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, ServletRequest request) {
        String error = "Not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError err = new StandardError(Instant.now(), e.getMessage(), status.value(), error, request.getRequestId());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException e, ServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        StandardError err = new StandardError(Instant.now(), e.getMessage(), status.value(), error, request.getRequestId());

        return ResponseEntity.status(status).body(err);
    }
}
