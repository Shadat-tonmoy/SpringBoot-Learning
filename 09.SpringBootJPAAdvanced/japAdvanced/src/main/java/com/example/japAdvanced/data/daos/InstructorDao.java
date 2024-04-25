package com.example.japAdvanced.data.daos;

import com.example.japAdvanced.data.entities.Instructor;
import com.example.japAdvanced.data.entities.InstructorDetails;

public interface InstructorDao {

    void save(Instructor instructor);

    Instructor findById(int id);

    InstructorDetails findDetailsById(int id);

    void deleteById(int id) throws Exception;
}
