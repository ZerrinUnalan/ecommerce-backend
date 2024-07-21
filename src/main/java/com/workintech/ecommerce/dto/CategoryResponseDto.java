package com.workintech.ecommerce.dto;

import com.workintech.ecommerce.entity.Gender;

public record CategoryResponseDto (Long id,String code,String title, String img, Double rating, Gender gender){
}