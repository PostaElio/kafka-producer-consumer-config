package com.example.demokafkaspringproducer.service;

import com.example.demokafkaspringproducer.dto.BankDto;
import com.example.demokafkaspringproducer.dto.UserDto;
import com.example.demokafkaspringproducer.events.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Event<?>> kafkaTemplate;
    @Value("${topic.customer.name:user}")
    private String topicUser;

    @Value("${topic.customer.name:bank}")
    private String topicBank;

    public void addUserInTopic(UserDto userDto) {
        UserCreatedEvent created = new UserCreatedEvent();
        created.setData(userDto);
        created.setId(UUID.randomUUID().toString());
        created.setType("CREATED_USER");//Darle un valor mas descriptivo
        created.setDate(LocalDateTime.now());

        this.kafkaTemplate.send(topicUser,"1", created);
    }

    public void addBankInTopic(BankDto bankDto) {
        BankCreatedEvent created = new BankCreatedEvent();
        created.setData(bankDto);
        created.setId(UUID.randomUUID().toString());
        created.setType("CREATED_BANK");
        created.setDate(LocalDateTime.now());

        this.kafkaTemplate.send(topicBank,"1", created);
    }
}
