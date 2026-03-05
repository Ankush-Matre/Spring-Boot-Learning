package com.coding.com.LearningSpringBootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "paymenet.type" , havingValue = "debitCard")
public class DebitCard implements PaymenetType{

    @Override
    public String pay(){
        System.out.println("Debit Card");
        return "Paymenet done from Debit Card";
    }
}

