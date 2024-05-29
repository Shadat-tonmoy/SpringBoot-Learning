package com.example.bloggingAPI.services;

import com.example.bloggingAPI.entities.Category;
import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.CategoryDto;
import com.example.bloggingAPI.repositories.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public CategoryDto createNewCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        category.setLastModified(System.currentTimeMillis());
        Category createdCategory = categoryRepo.save(category);
        CategoryDto createdCategoryDto = modelMapper.map(createdCategory, CategoryDto.class);
        return createdCategoryDto;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int categoryId) throws ResourceNotFoundException {
        Category categoryWithId = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId + ""));
        Category updatedCategory = modelMapper.map(categoryDto, Category.class);
        updatedCategory.setId(categoryId);
        updatedCategory.setLastModified(System.currentTimeMillis());
        Category updatedResult = categoryRepo.save(updatedCategory);
        CategoryDto updatedResultDto = modelMapper.map(updatedResult, CategoryDto.class);
        return updatedResultDto;
    }

    @Override
    public CategoryDto getCategoryById(int categoryId) throws ResourceNotFoundException {
        Category categoryWithId = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId + ""));
        CategoryDto categoryDto = modelMapper.map(categoryWithId, CategoryDto.class);
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = categoryRepo.findAll();
        List<CategoryDto> allCategoryDto = allCategories
                .stream()
                .map((category) -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
        return allCategoryDto;
    }
}
