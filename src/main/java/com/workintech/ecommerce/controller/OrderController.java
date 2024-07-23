package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.converter.Converter;
import com.workintech.ecommerce.dto.OrderRequestDto;
import com.workintech.ecommerce.dto.OrderResponseDto;
import com.workintech.ecommerce.entity.Order;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.service.OrderService;
import com.workintech.ecommerce.service.OrderedProductService;
import com.workintech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService orderService;
    private OrderedProductService orderedProductService;
    private ProductService productService;

    @Autowired
    public OrderController(OrderService orderService, OrderedProductService orderedProductService,
                           ProductService productService) {
        this.orderService = orderService;
        this.productService=productService;
        this.orderedProductService = orderedProductService;
    }

    @PostMapping("/")
    public OrderResponseDto saveOrder(@RequestBody OrderRequestDto order) {

        return orderService.saveOrder(order);
    }


}