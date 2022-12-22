package com.example.demokafkaspringproducer.events;

import com.example.demokafkaspringproducer.dto.UserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCreatedEvent extends Event<UserDto> {

}