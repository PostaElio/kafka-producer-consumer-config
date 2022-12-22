package com.example.demokafkaspringconsumer.events;

import com.example.demokafkaspringconsumer.dto.UserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserCreatedEvent extends Event<UserDto> {

}