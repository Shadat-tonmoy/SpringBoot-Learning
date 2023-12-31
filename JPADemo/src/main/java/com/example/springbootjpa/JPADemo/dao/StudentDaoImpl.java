package com.example.springbootjpa.JPADemo.dao;

import com.example.springbootjpa.JPADemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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

    @Override
    @Transactional
    public int updateStudentFirstName(int id, String firstName) {
        try {
            Query updateQuery = entityManager.createQuery("UPDATE Student SET firstName=:firstName WHERE id=:id");
            updateQuery.setParameter("firstName", firstName);
            updateQuery.setParameter("id", id);
            int numOfUpdatedRow = updateQuery.executeUpdate();
            return numOfUpdatedRow;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }

    @Override
    @Transactional
    public int deleteStudentById(int id) {
        try {
            Query deleteQuery = entityManager.createQuery("DELETE FROM Student WHERE id=:id");
            deleteQuery.setParameter("id", id);
            int numOfRowDeleted = deleteQuery.executeUpdate();
            return numOfRowDeleted;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
