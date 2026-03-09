package com.LearnSpringBoot.PresentationLayer.configs;

import org.modelmapper.ModelMapper;

public class MapperConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
