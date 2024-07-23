package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.dto.CategoryResponseDto;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/")
    public List<CategoryResponseDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/")
    public CategoryResponseDto save(@RequestBody Category category) {
        return categoryService.save(category);
    }

}