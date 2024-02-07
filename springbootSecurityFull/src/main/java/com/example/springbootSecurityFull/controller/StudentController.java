package com.example.springbootSecurityFull.controller;

import com.example.springbootSecurityFull.data.entity.Student;
import com.example.springbootSecurityFull.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class StudentController {


    private StudentService studentService;

    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String test() {
        return "<h2>Hello World</h2>";
    }


    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();

    }
}
