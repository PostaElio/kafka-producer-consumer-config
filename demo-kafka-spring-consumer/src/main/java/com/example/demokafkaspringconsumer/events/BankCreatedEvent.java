package com.example.demokafkaspringconsumer.events;


import com.example.demokafkaspringconsumer.dto.BankDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BankCreatedEvent extends Event<BankDto> {

}