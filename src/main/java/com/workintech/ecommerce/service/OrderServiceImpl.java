package com.workintech.ecommerce.service;

import com.workintech.ecommerce.converter.Converter;
import com.workintech.ecommerce.dto.OrderRequestDto;
import com.workintech.ecommerce.dto.OrderResponseDto;
import com.workintech.ecommerce.entity.Order;
import com.workintech.ecommerce.entity.Product;
import com.workintech.ecommerce.repository.OrderRepository;
import com.workintech.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRespository;
    private ModelMapperService modelMapperService;
    private ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRespository orderRespository,ModelMapperService modelMapperService,ProductRepository productRepository) {
        this.orderRespository = orderRespository;
        this.modelMapperService=modelMapperService;
        this.productRepository=productRepository;
    }

    @Override
    public OrderResponseDto saveOrder(OrderRequestDto orderRequest) {
        Order order= modelMapperService.forRequest().map(orderRequest, Order.class);
        List<Product> productsList=order.getProduct();
        order.setProduct(null);
        Order savedOrder=orderRespository.save(order);
        savedOrder.setProduct(productsList);
        orderRespository.save(savedOrder);
        return modelMapperService.forResponse().map(savedOrder, OrderResponse.class);
    }


}