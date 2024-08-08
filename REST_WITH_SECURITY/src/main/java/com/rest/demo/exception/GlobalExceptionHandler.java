package com.rest.demo.exception;

import jakarta.annotation.Priority;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Priority(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice //A anotação @ControllerAdvice é usada para definir uma classe que lida com exceções em nível global, ou seja, para todos os controladores da aplicação.
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    // Com a StudentNotFoundException.class na anotação, especifica que o método lida apenas com exceções do tipo StudentNotFoundException.
    //@ExceptionHandler // define um método que lida com todas as exceções gerenciadas pelo controlador, desde que o tipo de exceção seja compatível com o tipo de parâmetro do método.
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {

        StudentErrorResponse error = StudentErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<EmployeeErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex) {

        EmployeeErrorResponse error = EmployeeErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StudentErrorResponse> handleException(MethodArgumentTypeMismatchException ex) {

        StudentErrorResponse error = StudentErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Parameter should be of type int")
                .timeStamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    /*    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {

        StudentErrorResponse error = StudentErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .timeStamp(System.currentTimeMillis())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }*/
}
