package com.example.springbootSecurityFull.services;

import com.example.springbootSecurityFull.data.dao.StudentDao;
import com.example.springbootSecurityFull.data.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(@Autowired StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public Student getStudentById(long id) {
        return studentDao.getStudentById(id);
    }
}
