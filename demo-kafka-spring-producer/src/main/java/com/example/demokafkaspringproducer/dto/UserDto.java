package com.example.demokafkaspringproducer.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private String lastame;
    private int age;
    private String email;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime horaActual;

}
