package com.bakery.in.AssignmentLearning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class StrawBerryFrosting implements Frosting{

    @Override
    public String getFrostingType() {
        return "StrawberryFrosting";
    }
}
