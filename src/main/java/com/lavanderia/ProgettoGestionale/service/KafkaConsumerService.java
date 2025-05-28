package com.lavanderia.ProgettoGestionale.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "test-topic", groupId = "my-consumer-group")
    public void consume(String message){
        System.out.println("Received message: " + message);
    }
}
