package com.example.kafkaproducer.producer.controller;

import com.example.kafkaproducer.producer.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.kafkaproducer.producer.service.Producer;

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final Producer producer;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Order sendOrder(@RequestBody Order order) {
        log.info("Send order to kafka");
        producer.sendOrderEvent(order);
        return order;
    }

}
