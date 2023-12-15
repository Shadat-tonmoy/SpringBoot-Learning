package com.springboot.restDemo.controller;

import com.springboot.restDemo.entity.Student;
import com.springboot.restDemo.exceptions.StudentErrorResponse;
import com.springboot.restDemo.exceptions.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students"

    List<Student> studentList = new ArrayList<>();


    public StudentRestController() {
    }

    @PostConstruct
    public void initStudentList() {
        studentList = new ArrayList<>();

        studentList.add(new Student("First Name 1", "Last Name 1"));
        studentList.add(new Student("First Name 2", "Last Name 2"));
        studentList.add(new Student("First Name 3", "Last Name 3"));
        studentList.add(new Student("First Name 4", "Last Name 4"));
        studentList.add(new Student("First Name 5", "Last Name 5"));
        studentList.add(new Student("First Name 6", "Last Name 6"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        if (studentId >= studentList.size() || studentId < 0) {
            throw new StudentNotFoundException("Invalid Student Id - " + studentId);
        } else {
            return studentList.get(studentId);
        }
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
