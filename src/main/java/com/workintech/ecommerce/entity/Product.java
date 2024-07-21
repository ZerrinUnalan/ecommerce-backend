package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products",schema = "ecommerce")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "stock")
    private String stock;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "rating")
    private String rating;

    @Column(name = "sell_count")
    private String sellCount;

    @Column(name = "image")
    private String image;

    }

