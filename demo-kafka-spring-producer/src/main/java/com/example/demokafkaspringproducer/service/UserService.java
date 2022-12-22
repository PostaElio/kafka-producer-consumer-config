package com.example.demokafkaspringproducer.service;

import com.example.demokafkaspringproducer.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private KafkaService kafkaService;

    public void createUserDto(UserDto userDto){
        kafkaService.addUserInTopic(userDto);
        //Agregar en base de datos
    }



}
