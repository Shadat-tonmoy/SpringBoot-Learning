package com.example.bloggingAPI.repositories;

import com.example.bloggingAPI.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
