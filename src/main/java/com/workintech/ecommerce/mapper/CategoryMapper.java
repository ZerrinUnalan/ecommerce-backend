package com.workintech.ecommerce.mapper;

import com.workintech.ecommerce.dto.CategoryResponseDto;
import com.workintech.ecommerce.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryResponseDto toDto(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryResponseDto(category.getId(), category.getCode(), category.getTitle(),
                category.getImg(), category.getRating(), category.getGender());
    }

    public static List<CategoryResponseDto> toDtoList(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        return categories.stream().map(CategoryMapper::toDto).collect(Collectors.toList());
    }
}
