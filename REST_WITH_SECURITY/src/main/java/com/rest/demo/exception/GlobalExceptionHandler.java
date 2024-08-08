package com.rest.demo.exception;

import jakarta.annotation.Priority;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Priority(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {

        EmployeeErrorResponse error = EmployeeErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
