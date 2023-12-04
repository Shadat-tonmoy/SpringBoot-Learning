package com.example.springbootjpa.JPADemo.controllers;

import com.example.springbootjpa.JPADemo.dao.StudentDao;
import com.example.springbootjpa.JPADemo.entity.Student;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    private final StudentDao studentDao;
    private Gson gson;

    public StudentController(@Autowired StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @GetMapping("/add-student")
    public String addNewStudent() {
        Student newStudent = getStudent();
        studentDao.save(newStudent);
        String studentJson = gson.toJson(newStudent);
        return "Student is added successfully as "+studentJson;

    }

    private Student getStudent() {
        String firstName = "StudentFName : " + System.currentTimeMillis();
        String lastName = "StudentLName : " + System.currentTimeMillis();
        String email = firstName + "@email.com";
        Student student = new Student(firstName, lastName, email);
        return student;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
