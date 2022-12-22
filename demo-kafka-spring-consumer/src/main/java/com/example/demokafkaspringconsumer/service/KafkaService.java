package com.example.demokafkaspringconsumer.service;

import com.example.demokafkaspringconsumer.events.BankCreatedEvent;
import com.example.demokafkaspringconsumer.events.Event;

import com.example.demokafkaspringconsumer.events.UserCreatedEvent;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.internals.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component

public class KafkaService {

    @Autowired
    private ConcurrentKafkaListenerContainerFactory<String, Event<?>> kafkaListenerContainerFactory;

    @Autowired
    private ConsumerFactory<String, Event<?>> consumerFactory;

    @KafkaListener(
                topics = "${topic.customer.name:user}",
                containerFactory = "kafkaListenerContainerFactory",
                groupId = "grupo1")
        public void consumeruser(Event<?> event) throws JsonProcessingException {
//        kafkaListenerContainerFactory.getConsumerFactory()
            if (event.getClass().isAssignableFrom(UserCreatedEvent.class)) {
                UserCreatedEvent customerCreatedEvent = (UserCreatedEvent) event;
                String objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(customerCreatedEvent.getData());
                log.info("user------------------------------------------------------------------------------------------------------------------------------------");
                log.info("Received Customer created event .... with Id={}, data={}",
                        customerCreatedEvent.getId(),
                        objectMapper);
            }

        }

    @KafkaListener(
            topics = "${topic.customer.name:bank}",
            containerFactory = "kafkaListenerContainerFactory",
            groupId = "grupo1")
    public void consumerbank(ConsumerRecord<String, BankCreatedEvent> cr) throws JsonProcessingException {
            BankCreatedEvent customerCreatedEvent = cr.value();
            String objectMapper = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(cr.value().getData());

            log.info("bank------------------------------------------------------------------------------------------------------------------------------------");
            log.info("Received Customer created event .... with Id={}, data={}",
                    customerCreatedEvent.getId(),
                    objectMapper);
            log.info(""+cr.topic());
//            log.info(""+topic);
    }
}
