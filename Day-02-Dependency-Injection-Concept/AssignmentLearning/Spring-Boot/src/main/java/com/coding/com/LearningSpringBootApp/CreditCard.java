package com.coding.com.LearningSpringBootApp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "paymenet.type" , havingValue = "creditCard")
public class CreditCard implements PaymenetType{

    public String pay(){
        System.out.println("Credit Card");
        return "Paymenet done from Credit Card";
    }
}
