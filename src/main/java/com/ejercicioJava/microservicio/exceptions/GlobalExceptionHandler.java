package com.ejercicioJava.microservicio.exceptions;

import com.ejercicioJava.microservicio.enums.ErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import static com.ejercicioJava.microservicio.enums.ErrorMessages.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        logger.error(GENERAL_EXCEPTION.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(INTERNAL_SERVER_ERROR.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<String> handleNoHandlerFoundException(NoHandlerFoundException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NOT_FOUND_ERROR.getMessage());
    }
}
