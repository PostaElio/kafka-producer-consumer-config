package com.example.demokafkaspringproducer.controller;

import com.example.demokafkaspringproducer.dto.BankDto;
import com.example.demokafkaspringproducer.dto.UserDto;
import com.example.demokafkaspringproducer.service.BankService;
import com.example.demokafkaspringproducer.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BankService bankService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String agregarUser(){
        userService.createUserDto(new UserDto("elio","posta",23,"postaelio76@gmail.com",LocalDateTime.now()));
        bankService.createBank(new BankDto("galicia","direccion","lacuestio1","asdasd","asdasd",LocalDateTime.now()));

        return "Se agrego correctamente el usuario";
    }
}
