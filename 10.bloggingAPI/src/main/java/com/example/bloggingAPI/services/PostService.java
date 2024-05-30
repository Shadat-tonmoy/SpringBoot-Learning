package com.example.bloggingAPI.services;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId) throws ResourceNotFoundException;

    PostDto updatePost(PostDto postDto, int postId) throws ResourceNotFoundException;

    void deletePost(int postId) throws ResourceNotFoundException;

    PostDto getPostById(int id) throws ResourceNotFoundException;

    List<PostDto> getAllPost();

    List<PostDto> getPostByUser(int userId) throws ResourceNotFoundException;

    List<PostDto> getPostByCategory(int categoryId) throws ResourceNotFoundException;

    List<PostDto> searchPost(String searchString);


}
