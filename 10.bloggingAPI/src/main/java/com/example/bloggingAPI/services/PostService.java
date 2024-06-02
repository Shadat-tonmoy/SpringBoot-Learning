package com.example.bloggingAPI.services;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.PostDto;
import com.example.bloggingAPI.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, int userId, int categoryId) throws ResourceNotFoundException;

    PostDto updatePost(PostDto postDto, int postId) throws ResourceNotFoundException;

    void deletePost(int postId) throws ResourceNotFoundException;

    PostDto getPostById(int id) throws ResourceNotFoundException;

    PostResponse getAllPost(int pageNumber, int pageSize, String sortBy, boolean isDescending);

    PostResponse getPostByUser(int userId, int pageNumber, int pageSize) throws ResourceNotFoundException;

    List<PostDto> getPostByCategory(int categoryId) throws ResourceNotFoundException;

    List<PostDto> searchPost(String searchString);


}
