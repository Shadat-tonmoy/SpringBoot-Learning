package com.example.bloggingAPI.repositories;

import com.example.bloggingAPI.entities.Category;
import com.example.bloggingAPI.entities.Post;
import com.example.bloggingAPI.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findAllByUser(User user);

    Page<Post> findAllByUser(User user, Pageable pageable);

    List<Post> findAllByCategory(Category category);

    List<Post> findByTitleContaining(String keyword);
}
