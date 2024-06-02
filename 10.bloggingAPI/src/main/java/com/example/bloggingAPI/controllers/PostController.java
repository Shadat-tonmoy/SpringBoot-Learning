package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.OperationResponse;
import com.example.bloggingAPI.payloads.PostDto;
import com.example.bloggingAPI.services.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.PanelUI;
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
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "PageSize", defaultValue = "5", required = false) int pageSize) {
        List<PostDto> allPost = postService.getAllPost(pageNumber, pageSize);
        return new ResponseEntity<>(allPost, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int postId) throws ResourceNotFoundException {
        PostDto postDto = postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getAllPostByUser(@PathVariable int userId) throws ResourceNotFoundException {
        List<PostDto> postDtoList = postService.getPostByUser(userId);
        return new ResponseEntity<>(postDtoList, HttpStatus.OK);
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
}
