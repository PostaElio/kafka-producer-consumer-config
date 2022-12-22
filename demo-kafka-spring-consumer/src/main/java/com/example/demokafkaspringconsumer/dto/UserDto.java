package com.example.demokafkaspringconsumer.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class UserDto {
    private String name;
    private String lastame;
    private int age;
    private String email;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime horaActual;

}
