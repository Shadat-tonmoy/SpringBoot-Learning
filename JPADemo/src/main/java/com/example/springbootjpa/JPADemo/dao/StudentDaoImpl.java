package com.example.springbootjpa.JPADemo.dao;

import com.example.springbootjpa.JPADemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    public StudentDaoImpl(@Autowired EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void save(Student student) {
        try {
            entityManager.persist(student);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student findById(int id) {

        try {
            Student student = entityManager.find(Student.class, id);
            return student;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
