package com.stcodesapp.spring_boot_security.repositories;

import com.stcodesapp.spring_boot_security.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepos extends JpaRepository<Student,Integer> {

}
