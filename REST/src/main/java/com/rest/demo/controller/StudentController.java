package com.rest.demo.controller;

import com.rest.demo.exception.StudentErrorResponse;
import com.rest.demo.exception.StudentNotFoundException;
import com.rest.demo.domain.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequestMapping("/api")
@RestController
public class StudentController {

    private List<Student> students;

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

    @PostConstruct
    public void loadData() {
        students = List.of(
                new Student(1, "John", "Doe"),
                new Student(2, "Jane", "Doe"),
                new Student(3, "Bob", "Smith")
        );
    }

   // @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

  //  @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId) {
        if (studentId < 1 || studentId > students.size()) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId - 1);
    }
}
