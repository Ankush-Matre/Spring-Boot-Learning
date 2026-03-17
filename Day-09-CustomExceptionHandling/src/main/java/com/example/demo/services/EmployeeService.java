package com.example.demo.services;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.EmployeEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public Optional<EmployeeDto> getEmployeeById(Long id) {
        return employeeRepository
                .findById(id)
                .map(employeEntity -> modelMapper.map(employeEntity , EmployeeDto.class));
    }

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeEntity> entities = employeeRepository.findAll();
        return entities
                .stream()
                .map(employeEntity -> modelMapper.map(employeEntity , EmployeeDto.class))
                .collect(Collectors.toList());
    }

    public void isExistsByEmployeeId(Long employeeId){
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists){
            throw new ResourceNotFoundException("Empployee not found with id : " + employeeId);
        }
    }


    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto, Long employeeId) {
        isExistsByEmployeeId(employeeId);
        EmployeEntity employeEntity = modelMapper.map(employeeDto, EmployeEntity.class);
        employeEntity.setId(employeeId);
        EmployeEntity savedEmployeeEntity = employeeRepository.save(employeEntity);
        return modelMapper.map(savedEmployeeEntity , EmployeeDto.class);
    }

    public boolean deleteEmployee(Long employeeId) {
        isExistsByEmployeeId(employeeId);
        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeDto updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        isExistsByEmployeeId(employeeId);
        EmployeEntity employeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field , value) -> {

            Field fieldToBeUpdated = ReflectionUtils.findField(EmployeEntity.class , field);

            if(fieldToBeUpdated != null){
                fieldToBeUpdated.setAccessible(true);
                ReflectionUtils.setField(fieldToBeUpdated , employeEntity , value);
            }

        });
        return modelMapper.map(employeeRepository.save(employeEntity) , EmployeeDto.class);
    }
}
