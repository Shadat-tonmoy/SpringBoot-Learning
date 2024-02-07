package com.example.springbootSecurityFull.data.dao;

import com.example.springbootSecurityFull.data.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> getAllStudent();

    Student getStudentById(long id);

}
