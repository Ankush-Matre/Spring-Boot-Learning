package com.bakery.in.AssignmentLearning;

import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private final Frosting f;
    private final Syrup s;

    public CakeBaker(Frosting f , Syrup s){
        this.f = f;
        this.s = s;
    }

    public void bakeCake(){
        System.out.println("Baking cake with "
                + f.getFrostingType()
                + " and "
                + s.getSyrupType());
    }

}

