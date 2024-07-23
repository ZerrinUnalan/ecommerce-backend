package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.OrderRequestDto;
import com.workintech.ecommerce.dto.OrderResponseDto;
import com.workintech.ecommerce.entity.Order;

public interface OrderService {
    OrderResponseDto saveOrder(OrderRequestDto orderRequest);

}