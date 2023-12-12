package com.springboot.restDemo.controller;

import com.springboot.restDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students"

    List<Student> studentList = new ArrayList<>();


    public StudentRestController() {}

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
        if (studentId < studentList.size()) {
            return studentList.get(studentId);
        }
        return null;
    }


}
