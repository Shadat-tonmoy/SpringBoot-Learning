package com.example.japAdvanced.data.daos;

import com.example.japAdvanced.data.entities.Instructor;

public interface InstructorDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    void deleteById(int id) throws Exception;
}
