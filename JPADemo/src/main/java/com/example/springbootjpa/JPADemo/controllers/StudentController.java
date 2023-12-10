package com.example.springbootjpa.JPADemo.controllers;

import com.example.springbootjpa.JPADemo.dao.StudentDao;
import com.example.springbootjpa.JPADemo.entity.Student;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return "Student is added successfully as " + studentJson;

    }

    @GetMapping("/get-single-student")
    public String getStudentById() {
        Student student = studentDao.findById(15);
        String studentJson = gson.toJson(student);
        return studentJson;
    }


    @GetMapping("/students")
    public String getAllStudent() {
        List<Student> allStudent = studentDao.getAll();
        String allStudentJson = gson.toJson(allStudent);
        return allStudentJson;
    }


    @GetMapping("/student-by-email")
    public String getStudentByEmail() {
        String email = "student1@emaili.com";
        Student student = studentDao.findByEmail(email);
        if (student != null) {
            String studentJson = gson.toJson(student);
            return studentJson;
        } else {
            return "{}";
        }
    }


    @GetMapping("/update-student")
    public String updateStudent() {
        int id = 1;
        Student student = studentDao.findById(id);
        if (student != null) {
            student.setFirstName("Updated First Name @ " + System.currentTimeMillis());
            studentDao.updateStudent(student);
            return "Student has been updated!";
        }
        return "Could not find any student with the id!";

    }

    @GetMapping("/update-student-by-id")
    public String updateStudentLastName() {
        int id = 2;
        String firstName = "UpdatedFirstName @ " + System.currentTimeMillis();
        int numOfRowUpdated = studentDao.updateStudentFirstName(id, firstName);
        return "TotalUpdatedRow : " + numOfRowUpdated;
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
