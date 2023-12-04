package com.example.springbootjpa.JPADemo.dao;

import com.example.springbootjpa.JPADemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {


    private EntityManager entityManager;

    public StudentDaoImpl(@Autowired EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public List<Student> getAll() {
        return null;
    }
}
