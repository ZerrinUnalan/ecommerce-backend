package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.dto.ProductResponseDto;
import com.workintech.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

    public interface ProductRepository extends JpaRepository<Product, Long> {

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, \n" +
                "p.category_id FROM ecommerce.products AS p WHERE p.name ILIKE %:productName%", nativeQuery = true)
        Optional<Product> findByProductName(String productName);

        @Query(value = "SELECT * FROM ecommerce.products AS p WHERE p.category_id = :categoryID",nativeQuery = true)
        List<Product> getProductByCategoryId(long categoryID);

        @Query(value = "SELECT * FROM ecommerce.products AS p WHERE p.id = :id",nativeQuery = true)
        Product getProductById(long id);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id=:categoryID, p.name ILIKE %:name% ORDER BY p.price DESC", nativeQuery = true)
        List<Product> searchAndDescSortAndCategory(long categoryID,String name);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id=:categoryID, p.name ILIKE %:name% ORDER BY p.price ASC", nativeQuery = true)
        List<Product> searchAndAscSortAndCategory(long categoryID,String name);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id=:categoryID, p.name ILIKE %:name% ORDER BY p.rating DESC", nativeQuery = true)
        List<Product> searchAndBestSortAndCategory(long categoryID,String name);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id=:categoryID, p.name ILIKE %:name% ORDER BY p.rating DESC", nativeQuery = true)
        List<Product> searchAndWorstSortAndCategory(long categoryID,String name);
        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.name ILIKE %:name%", nativeQuery = true)
        List<Product> searchByName(String name);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id:categoryID , p.name ILIKE %:name%", nativeQuery = true)
        List<Product> searchByNameAndCategory(String name,long categoryID);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p ORDER BY p.price DESC", nativeQuery = true)
        List<Product> highestToLowestSorting();

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id = :categoryID ORDER BY p.price DESC", nativeQuery = true)
        List<Product> highestToLowestSortingAndCategory(long categoryID);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p ORDER BY p.price ASC", nativeQuery = true)
        List<Product> lowestToHighestSorting();

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p  WHERE p.category_id = :categoryID ORDER BY p.price ASC", nativeQuery = true)
        List<Product> lowestToHighestSortingAndCategory(long categoryID);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p ORDER BY p.rating ASC", nativeQuery = true)
        List<Product> worstToBestSorting();

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id = :categoryID ORDER BY p.rating ASC", nativeQuery = true)
        List<Product> worstToBestSortingAndCategory(long categoryID);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p ORDER BY p.rating DESC", nativeQuery = true)
        List<Product> bestToWorstSorting();

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.category_id = :categoryID ORDER BY p.rating DESC", nativeQuery = true)
        List<Product> bestToWorstSortingAndCategory(long categoryID);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.name ILIKE %:name% ORDER BY p.price ASC", nativeQuery = true)
        List<Product> searchAndLowestSorting(String name);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.name ILIKE %:name% ORDER BY p.price DESC", nativeQuery = true)
        List<Product> searchAndHighestSorting(String name);

        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.name ILIKE %:name% ORDER BY p.rating ASC", nativeQuery = true)
        List<Product> searchAndWorstSorting(String name);
        @Query(value = "SELECT p.id, p.name, p.description, p.price, p.rating, p.sell_count, p.stock, p.image, p.category_id" +
                " FROM ecommerce.products AS p WHERE p.name ILIKE %:name% ORDER BY p.rating DESC", nativeQuery = true)
        List<Product> searchAndBestSorting(String name);



    }