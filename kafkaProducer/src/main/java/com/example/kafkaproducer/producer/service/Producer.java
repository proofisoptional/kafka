package com.example.kafkaproducer.producer.service;


import com.example.kafkaproducer.producer.entity.Order;
import com.example.kafkaproducer.producer.entity.OrderSentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {
    private final KafkaMessagingService kafkaMessagingService;
    private final ModelMapper modelMapper;

    public Order sendOrderEvent (Order order){
        kafkaMessagingService.sendOrder(modelMapper.map(order, OrderSentEvent.class));
        log.info("Send order from producer {}", order);
        return order;
    }
}
