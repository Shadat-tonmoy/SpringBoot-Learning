package com.stcodesapp.spring_boot_security.repositories;

import com.stcodesapp.spring_boot_security.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUserName(String userName);

}
