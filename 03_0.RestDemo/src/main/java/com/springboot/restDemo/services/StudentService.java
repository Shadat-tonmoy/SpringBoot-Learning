package com.springboot.restDemo.services;

import com.springboot.restDemo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    Student getStudentById(int id);

    int updateStudent(Student student);

    int deleteStudent(Student student);

}
