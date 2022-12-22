package com.example.demokafkaspringconsumer.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = UserCreatedEvent.class, name = "CREATED_USER"),
        @JsonSubTypes.Type(value = BankCreatedEvent.class, name = "CREATED_BANK"),

})
public abstract class Event <T> {
    private String id;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime date;
    private String type;
    private T data;
}
