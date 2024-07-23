package com.workintech.ecommerce.service;


import com.workintech.ecommerce.converter.Converter;
import com.workintech.ecommerce.dto.CategoryResponseDto;
import com.workintech.ecommerce.entity.Category;
import com.workintech.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.repository.CategoryRepository;
import com.workintech.ecommerce.util.validations.GeneralValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDto> getAllCategories() {
        return Converter.findCategories(categoryRepository.findAll());
    }

    @Override
    public Category getCategoryByID(long id) {
        GeneralValidation.isValid(id,"category id ");
        GeneralValidation.isCategoryIdValid("category id ",id);
        try{
            Category foundCategory= categoryRepository.getCategoryByID(id);
            return foundCategory;
        }catch(CommerceException ex){
            throw new CommerceException("Category not found!", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public CategoryResponseDto save(Category category) {
        GeneralValidation.checkEmptyOrNull(category.getCode(),"code ");
        GeneralValidation.checkEmptyOrNull(category.getImg(),"img ");
        GeneralValidation.checkEmptyOrNull(category.getTitle(),"title ");
        GeneralValidation.isValid(category.getRating(),"rating ");
        Category saved = categoryRepository.save(category);
        return new CategoryResponseDto(category.getId(), category.getCode(), category.getTitle(),
                category.getImg(), category.getRating(), category.getGender());
    }
}