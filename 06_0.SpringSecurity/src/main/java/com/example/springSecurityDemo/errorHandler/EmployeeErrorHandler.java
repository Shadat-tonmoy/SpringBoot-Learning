package com.example.springSecurityDemo.errorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeErrorHandler {


    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleEmployeeError(Exception exception){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorMessage.setMessage(exception.getMessage());
        errorMessage.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);


    }

}
