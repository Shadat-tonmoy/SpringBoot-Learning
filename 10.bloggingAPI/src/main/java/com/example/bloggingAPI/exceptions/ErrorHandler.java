package com.example.bloggingAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleException(Exception exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorStatus(HttpStatus.NOT_FOUND.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
