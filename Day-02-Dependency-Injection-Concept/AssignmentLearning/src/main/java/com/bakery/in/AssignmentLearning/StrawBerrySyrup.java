package com.bakery.in.AssignmentLearning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StrawBerrySyrup implements Syrup{

    @Override
    public String getSyrupType(){
        return "Strawberry Syrrup";
    }
}
