package com.example.demokafkaspringproducer.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BankDto {
    private String name;
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime horaActual;
}
