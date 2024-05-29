package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.PostDto;
import com.example.bloggingAPI.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public PostDto createNewPost(@Valid @RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId) throws ResourceNotFoundException {
        PostDto newPostDto = postService.createPost(postDto, userId, categoryId);
        return newPostDto;
    }
}
