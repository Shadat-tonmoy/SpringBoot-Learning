package com.stcodesapp.springbootjdbc.service;

import com.stcodesapp.springbootjdbc.models.Student;
import com.stcodesapp.springbootjdbc.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo repo;

    public void addStudent(Student student) {
        repo.addStudent(student);
    }

    public void printAllStudents() {
        List<Student> allStudents = repo.getAllStudents();
        for(Student student : allStudents) {
            System.out.println("Student : \n============\n"+student.toString()+"\n============\n");
        }
    }


}
