package com.LearnSpringBoot.PresentationLayer.controller;

import com.LearnSpringBoot.PresentationLayer.dto.EmployeeDto;
import com.LearnSpringBoot.PresentationLayer.entity.EmployeeEntity;
import com.LearnSpringBoot.PresentationLayer.repositoty.EmployeeRepository;
import com.LearnSpringBoot.PresentationLayer.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping(path = "/getSecretmessage")
//    public String getMessage(){
//        return "I am Hacker";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/{employeeId}")
    public EmployeeDto getEmployeeData(@PathVariable(name = "employeeId") Long employeeId){
        return employeeService.getEmployeeById(employeeId);

    }

    @GetMapping
    public List<EmployeeDto> getMessege(@RequestParam(required = false) Integer age,
                             @RequestParam(required = false) String msg){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto inputDto){

        return employeeService.createNewEmployee(inputDto);
    }

    @PutMapping
    public String putMapping(){
        return "Hi I am from putMapping";
    }
}
