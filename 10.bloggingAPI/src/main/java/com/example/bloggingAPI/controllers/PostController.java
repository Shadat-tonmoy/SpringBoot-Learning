package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.constans.ConstValues;
import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.OperationResponse;
import com.example.bloggingAPI.payloads.PostDto;
import com.example.bloggingAPI.payloads.PostResponse;
import com.example.bloggingAPI.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createNewPost(@Valid @RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId) throws ResourceNotFoundException {
        PostDto newPostDto = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(newPostDto, HttpStatus.CREATED);
    }

    @PutMapping("post/{postId}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable int postId) throws ResourceNotFoundException {
        PostDto updatedPostDto = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatedPostDto, HttpStatus.OK);
    }


    @GetMapping("posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = ConstValues.DEFAULT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = ConstValues.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = ConstValues.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "isDescending", defaultValue = "false", required = false) boolean isDescending
    ) {
        PostResponse postResponse = postService.getAllPost(pageNumber, pageSize, sortBy, isDescending);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int postId) throws ResourceNotFoundException {
        PostDto postDto = postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<PostResponse> getAllPostByUser(
            @PathVariable int userId,
            @RequestParam(value = "pageNumber", defaultValue = ConstValues.DEFAULT_PAGE_NUMBER, required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = ConstValues.DEFAULT_PAGE_SIZE, required = false) int pageSize) throws ResourceNotFoundException {
        PostResponse postResponse = postService.getPostByUser(userId, pageNumber, pageSize);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getAllPostByCategory(@PathVariable int categoryId) throws ResourceNotFoundException {
        List<PostDto> postDtoList = postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<OperationResponse> deletePost(@PathVariable int postId) throws ResourceNotFoundException {
        postService.deletePost(postId);
        return new ResponseEntity<>(new OperationResponse(true, "Post is deleted successfully"), HttpStatus.OK);
    }

    @GetMapping("posts/search/{searchString}")
    public ResponseEntity<List<PostDto>> searchForPost(@PathVariable String searchString) {
//        List<PostDto> postDtoList = postService.searchPost(searchString);
        List<PostDto> postDtoList = postService.searchForPost(searchString);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
    }
}
