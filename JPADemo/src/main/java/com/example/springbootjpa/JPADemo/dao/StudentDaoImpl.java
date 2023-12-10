package com.example.springbootjpa.JPADemo.dao;

import com.example.springbootjpa.JPADemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
        TypedQuery<Student> allStudentQuery = entityManager.createQuery("FROM Student", Student.class);
        List<Student> studentList = allStudentQuery.getResultList();
        return studentList;
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

    @Override
    public Student findByEmail(String email) {
        try {
            TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE email = :email", Student.class);
            query.setParameter("email", email);
            List<Student> studentList = query.getResultList();
            if (!studentList.isEmpty()) {
                return studentList.get(0);
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        try {
            entityManager.merge(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
