package com.demo.exceptions.handlers;

import com.demo.exceptions.DemoDontFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

/**
 * Handle all exceptions that happens in @Controller
 */
@ControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception e) {
        return new ResponseEntity<>(Map.of("error", "An error has occurred.", "devMessage", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DemoDontFoundException.class)
    public ResponseEntity handleException(DemoDontFoundException e) {
        return new ResponseEntity<>(Map.of("error", "Data don't found.", "devMessage", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleAccessDeniedException(DataIntegrityViolationException e) {
        return new ResponseEntity<>(Map.of("error", "Invalid data.", "devMessage", e.getCause().getCause().getMessage()), HttpStatus.BAD_REQUEST);
    }
}