package com.example.demokafkaspringproducer.events;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public abstract class Event <T> {
    private String id;
    @JsonSerialize(using = LocalDateTimeSerializer.class)//Nos sirve para que lo pueda escribir en JSON al localdatetime ya que es una clase de java 8
    private LocalDateTime date;
    private String type;
    private T data;
}