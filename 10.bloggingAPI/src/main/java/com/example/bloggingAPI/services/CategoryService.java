package com.example.bloggingAPI.services;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createNewCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) throws ResourceNotFoundException;

    CategoryDto getCategoryById(int categoryId) throws ResourceNotFoundException;

    List<CategoryDto> getAllCategories();
}
