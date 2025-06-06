package com.lavanderia.ProgettoGestionale.service;

import com.lavanderia.ProgettoGestionale.model.dto.ClienteDto;
import com.lavanderia.ProgettoGestionale.model.entity.Cliente;
import com.lavanderia.ProgettoGestionale.model.mapper.ClienteMapper;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteService clienteService;

    private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "test-topic", groupId = "my-consumer-group")
    public void consume(String message){
        logger.info("Message received: {}", message);
    }

    @KafkaListener(topics = "cliente", groupId = "my-consumer-group")
    public void getClienteToSave(@Payload ClienteDto dto){
        if(dto == null){
            logger.error("Oggetto nullo");
            return;
        }
        clienteService.postCliente(dto);

    }
}
