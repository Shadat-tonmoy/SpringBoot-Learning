package com.example.japAdvanced.data.daos;

import com.example.japAdvanced.data.entities.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InstructorDaoImpl implements InstructorDao {

    private EntityManager entityManager;

    @Autowired
    public InstructorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    @Transactional
    public void deleteById(int id) throws Exception {
        Instructor instructor = entityManager.find(Instructor.class, id);
        if (instructor != null) {
            entityManager.remove(instructor);
        } else {
            throw new Exception("No Instructor Found with id : " + id);
        }
    }
}
