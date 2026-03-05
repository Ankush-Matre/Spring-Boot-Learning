package com.bakery.in.AssignmentLearning;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ChocolateFrosting implements Frosting{

    @Override
    public String getFrostingType(){
        return "Chocolate Frosting";
    }
}
