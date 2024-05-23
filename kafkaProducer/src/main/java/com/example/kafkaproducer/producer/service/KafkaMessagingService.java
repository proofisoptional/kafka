package com.example.kafkaproducer.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.kafkaproducer.producer.entity.OrderSentEvent;

@Service
@RequiredArgsConstructor
public class KafkaMessagingService {
    @Value("${topic.send-order}")
    private String sendClientTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrder(OrderSentEvent event){
        kafkaTemplate.send(sendClientTopic, event.getBarCode(), event);

    }
}
