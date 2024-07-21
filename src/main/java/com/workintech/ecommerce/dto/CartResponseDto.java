package com.workintech.ecommerce.dto;

public record CartResponseDto(long productId, int count, String detail) {
}