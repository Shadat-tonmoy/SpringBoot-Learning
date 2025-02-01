package com.stcodesapp.spring_boot_security.services;

import com.stcodesapp.spring_boot_security.models.Student;
import com.stcodesapp.spring_boot_security.repositories.StudentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepos repository;


    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student addNewStudent(Student student) {
        Student newStudent = repository.save(student);
        return newStudent;
    }




}
