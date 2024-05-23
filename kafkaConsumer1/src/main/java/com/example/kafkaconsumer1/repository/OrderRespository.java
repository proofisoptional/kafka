package com.example.kafkaconsumer1.repository;

import com.example.kafkaconsumer1.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRespository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByBarCode(String barCode);
    List<Order> findOrdersByProductName(String productName);
}
