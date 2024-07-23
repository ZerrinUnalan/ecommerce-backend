package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.CategoryResponseDto;
import com.workintech.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategories();
    Category getCategoryByID(long id);
    CategoryResponseDto save(Category category);


}