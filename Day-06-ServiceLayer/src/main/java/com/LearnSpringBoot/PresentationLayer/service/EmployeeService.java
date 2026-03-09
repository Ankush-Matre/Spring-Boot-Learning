package com.LearnSpringBoot.PresentationLayer.service;

import com.LearnSpringBoot.PresentationLayer.dto.EmployeeDto;
import com.LearnSpringBoot.PresentationLayer.entity.EmployeeEntity;
import com.LearnSpringBoot.PresentationLayer.repositoty.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto getEmployeeData(Long Id){
        EmployeeEntity entity = employeeRepository.findBy(Id).orElse(null);
        return modelMapper.map(employeeEntity , EmployeeDto.class);
    }

    //here we can also add some more methods as well to do the logic in the service layer

}
