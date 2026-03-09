package com.example.demo.services;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.EmployeEntity;
import com.example.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto createNewEmployee(EmployeeDto inputEmployee) {
        EmployeEntity toSaveEntity = modelMapper.map(inputEmployee , EmployeEntity.class);
        EmployeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity , EmployeeDto.class);
    }

    public EmployeeDto getEmployeeById(Long id) {
        EmployeEntity employeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeEntity , EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeEntity> entities = employeeRepository.findAll();
        return entities
                .stream()
                .map(employeEntity -> modelMapper.map(employeEntity , EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
