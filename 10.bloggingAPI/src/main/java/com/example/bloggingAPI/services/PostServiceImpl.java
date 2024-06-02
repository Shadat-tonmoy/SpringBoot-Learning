package com.example.bloggingAPI.services;

import com.example.bloggingAPI.entities.Category;
import com.example.bloggingAPI.entities.Post;
import com.example.bloggingAPI.entities.User;
import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.PostDto;
import com.example.bloggingAPI.repositories.CategoryRepo;
import com.example.bloggingAPI.repositories.PostRepo;
import com.example.bloggingAPI.repositories.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto, int userId, int categoryId) throws ResourceNotFoundException {
        User userWithId = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId + ""));
        Category categoryWithId = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId + ""));
        Post newPost = modelMapper.map(postDto, Post.class);
        newPost.setImageName("default.png");
        newPost.setLastUpdated(System.currentTimeMillis());
        newPost.setUser(userWithId);
        newPost.setCategory(categoryWithId);
        Post savedPost = postRepo.save(newPost);
        PostDto savedPostDto = modelMapper.map(savedPost, PostDto.class);
        return savedPostDto;
    }

    @Override
    public PostDto updatePost(PostDto postDto, int postId) throws ResourceNotFoundException {
        Post postWithId = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId + ""));
        postWithId.setContent(postDto.getContent());
        postWithId.setTitle(postDto.getTitle());
        postWithId.setLastUpdated(System.currentTimeMillis());
        Post updatedPost = postRepo.save(postWithId);
        PostDto updatedPostDto = modelMapper.map(updatedPost, PostDto.class);
        return updatedPostDto;
    }

    @Override
    public void deletePost(int postId) throws ResourceNotFoundException {
        Post postWithId = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId + ""));
        postRepo.delete(postWithId);
    }

    @Override
    public PostDto getPostById(int id) throws ResourceNotFoundException {
        Post postById = postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id + ""));
        PostDto postDto = modelMapper.map(postById, PostDto.class);
        return postDto;
    }

    @Override
    public List<PostDto> getAllPost(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Post> pageResult = postRepo.findAll(pageRequest);
        long totalElement = pageResult.getTotalElements();
        int totalPage = pageResult.getTotalPages();
        List<Post> postList = pageResult.getContent();
        System.out.println("Get all post : " + postList + " pageNumber : " + pageNumber + " pageSize : " + pageSize + " totalElement : " + totalElement + " totalPage : " + totalPage);
        // List<Post> postList = postRepo.findAll();
        List<PostDto> postDtoList = postList.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> getPostByUser(int userId) throws ResourceNotFoundException {
        User userWithId = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId + ""));
        List<Post> postListByUser = postRepo.findAllByUser(userWithId);
        List<PostDto> postDtoList = postListByUser.stream()
                .map((post -> modelMapper.map(post, PostDto.class)))
                .collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> getPostByCategory(int categoryId) throws ResourceNotFoundException {
        Category categoryWithId = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId + ""));
        List<Post> postListByCategory = postRepo.findAllByCategory(categoryWithId);
        List<PostDto> postDtoList = postListByCategory.stream()
                .map((post -> modelMapper.map(post, PostDto.class)))
                .collect(Collectors.toList());
        return postDtoList;
    }

    @Override
    public List<PostDto> searchPost(String searchString) {
        return List.of();
    }
}
