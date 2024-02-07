package com.example.springbootSecurityFull.data.dao;

import com.example.springbootSecurityFull.data.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
    public List<Student> getAllStudent() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);
        List<Student> studentList = query.getResultList();
        System.out.println("Get all student list :" +studentList);
        return studentList;
    }

    @Override
    public Student getStudentById(long id) {
        Query query = entityManager.createQuery("FROM Student WHERE id = :id");
        query.setParameter("id", id);
        List<Student> result = query.getResultList();
        System.out.println("Single Student : " + result);
        return null;
    }
}
