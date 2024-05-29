package com.example.bloggingAPI.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleInvalidArgumentException(MethodArgumentNotValidException exception) {
        ErrorMessage errorMessage = new ErrorMessage();
        StringBuilder errorMessageBuilder = new StringBuilder();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            FieldError fieldError = (FieldError) error;
            String fieldName = fieldError.getField();
            String message = error.getDefaultMessage();
            errorMessageBuilder.append(fieldName+" : ");
            errorMessageBuilder.append(message);
        });
        errorMessage.setErrorStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(errorMessageBuilder.toString());
        errorMessage.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

    }
}
