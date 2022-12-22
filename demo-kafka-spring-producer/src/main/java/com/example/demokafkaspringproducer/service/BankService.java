package com.example.demokafkaspringproducer.service;

import com.example.demokafkaspringproducer.dto.BankDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private KafkaService kafkaService;

    public void createBank(BankDto bankDto){
        kafkaService.addBankInTopic(bankDto);
    }
}
