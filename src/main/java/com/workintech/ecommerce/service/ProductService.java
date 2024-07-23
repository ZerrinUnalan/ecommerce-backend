package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<ProductResponseDto> saveAll(List<Product> productsList);
    ProductResponseDto findByProductName(String name);
    List<Product> getProductsByCategoryId(long categoryID);
    List<ProductResponseDto> searchByName(String name);
    List<ProductResponseDto> highestToLowestSorting();
    List<ProductResponseDto> lowestToHighestSorting();
    List<ProductResponseDto> worstToBestSorting();
    List<ProductResponseDto> bestToWorstSorting();
    List<ProductResponseDto> searchAndLowestSorting(String name);
    List<ProductResponseDto> searchAndHighestSorting(String name);
    List<ProductResponseDto> searchAndWorstSorting(String name);
    List<ProductResponseDto> searchAndBestSorting(String name);
    List<Product> getAllProducts();
    Product deleteProduct(long id);
    Product getProductById(long id);
    List<Product> searchByNameAndCategory(String name,long categoryID);
    List<Product> searchAndWorstSortAndCategory(long categoryID,String name);
    List<Product> searchAndBestSortAndCategory(long categoryID,String name);
    List<Product> searchAndAscSortAndCategory(long categoryID,String name);
    List<Product> searchAndDescSortAndCategory(long categoryID,String name);
    List<Product> highestToLowestSortingAndCategory(long categoryID);
    List<Product> lowestToHighestSortingAndCategory(long categoryID);
    List<Product> worstToBestSortingAndCategory(long categoryID);
    List<Product> bestToWorstSortingAndCategory(long categoryID);
}