package com.example.springbootSecurityFull.services;

import com.example.springbootSecurityFull.data.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student getStudentById(long id);

}
