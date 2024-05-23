package com.example.kafkaconsumer1.service;

import com.example.kafkaconsumer1.dto.OrderDto;
import com.example.kafkaconsumer1.entity.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.kafkaconsumer1.repository.OrderRespository;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRespository repository;
    public void save(OrderDto orderDto){
        Order order = toEntity(orderDto);
        repository.save(order);
    }
    private Order toEntity(OrderDto dto){
        Order order = new Order();
        order.setPrice(dto.getPrice());
        order.setBarCode(dto.getBarCode());
        order.setQuantity(dto.getQuantity());
        order.setProductName(dto.getProductName());
        return order;
    }
}
