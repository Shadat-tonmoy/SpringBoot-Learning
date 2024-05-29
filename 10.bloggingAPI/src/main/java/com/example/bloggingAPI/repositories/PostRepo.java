package com.example.bloggingAPI.repositories;

import com.example.bloggingAPI.entities.Category;
import com.example.bloggingAPI.entities.Post;
import com.example.bloggingAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findAllByUser(User user);

    List<Post> findAllByCategory(Category category);
}
