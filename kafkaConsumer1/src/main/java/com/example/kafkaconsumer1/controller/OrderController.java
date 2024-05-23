package com.example.kafkaconsumer1.controller;

import com.example.kafkaconsumer1.entity.Order;
import com.example.kafkaconsumer1.repository.OrderRespository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/order-api/")
public class OrderController {
    private OrderRespository orderRespository;

    @GetMapping("/get-order")
    public ResponseEntity<Order> getOrder(@RequestParam("id") Long id){
        System.out.println("log controller");
        Order order = orderRespository.findById(id).orElse(null);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
