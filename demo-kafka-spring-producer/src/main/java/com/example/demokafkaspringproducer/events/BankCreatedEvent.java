package com.example.demokafkaspringproducer.events;

import com.example.demokafkaspringproducer.dto.BankDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BankCreatedEvent extends Event<BankDto> {

}