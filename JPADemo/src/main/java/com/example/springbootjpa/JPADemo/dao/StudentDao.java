package com.example.springbootjpa.JPADemo.dao;

import com.example.springbootjpa.JPADemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);


    List<Student> getAll();

    Student findById(int id);

    Student findByEmail(String email);

    void updateStudent(Student student);

    int updateStudentFirstName(int id, String firstName);

    int deleteStudentById(int id);


}
