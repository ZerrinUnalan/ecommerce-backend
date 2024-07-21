package com.workintech.ecommerce.dto;

public record ProductResponseDto (Long id, String name, String description, String price, String stock, Long categoryID, String rating, String sellCount,String image) {
}