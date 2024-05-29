package com.example.bloggingAPI.controllers;

import com.example.bloggingAPI.exceptions.ResourceNotFoundException;
import com.example.bloggingAPI.payloads.CategoryDto;
import com.example.bloggingAPI.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public CategoryDto createNewCategory(@Valid @RequestBody CategoryDto categoryDto) {
        System.out.println("Create new category with : " + categoryDto);
        CategoryDto createdCategory = categoryService.createNewCategory(categoryDto);
        return createdCategory;
    }

    @PutMapping("/{categoryId}")
    public CategoryDto updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable int categoryId) throws ResourceNotFoundException {
        System.out.println("Update category with id : " + categoryId + " updated body : " + categoryDto);
        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId);
        return updatedCategory;
    }

    @GetMapping("/{categoryId}")
    public CategoryDto getCategoryById(@PathVariable int categoryId) throws ResourceNotFoundException {
        System.out.println("Get category by id : " + categoryId);
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return categoryDto;
    }

    @GetMapping("/")
    public List<CategoryDto> getAllCategory() {
        System.out.println("getAllCategory");
        List<CategoryDto> allCategories = categoryService.getAllCategories();
        return allCategories;
    }
}
