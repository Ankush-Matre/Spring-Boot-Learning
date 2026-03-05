package com.bakery.in.AssignmentLearning;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ChocolateSyrup implements Syrup{

    @Override
    public String getSyrupType(){
        return "Chocolate Syrup";
    }
}
