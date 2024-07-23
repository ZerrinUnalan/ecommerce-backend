package com.workintech.ecommerce.mapper;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductResponseDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductResponseDto(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), product.getStock(), product.getCategoryId(), product.getRating(),
                product.getSellCount(), product.getImage());
    }

    public static List<ProductResponseDto> toDtoList(List<Product> products) {
        if (products == null) {
            return null;
        }
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }
}
