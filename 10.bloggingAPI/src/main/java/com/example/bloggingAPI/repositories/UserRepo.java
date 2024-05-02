package com.example.bloggingAPI.repositories;

import com.example.bloggingAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
