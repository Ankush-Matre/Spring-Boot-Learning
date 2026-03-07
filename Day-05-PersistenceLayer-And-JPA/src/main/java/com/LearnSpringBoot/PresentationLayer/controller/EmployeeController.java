package com.LearnSpringBoot.PresentationLayer.controller;

import com.LearnSpringBoot.PresentationLayer.dto.EmployeeDto;
import com.LearnSpringBoot.PresentationLayer.entity.EmployeeEntity;
import com.LearnSpringBoot.PresentationLayer.repositoty.EmployeeRepository;
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

    private final EmployeeRepository employeerepo;

    public EmployeeController(EmployeeRepository employeerepo){
        this.employeerepo = employeerepo;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeData(@PathVariable(name = "employeeId") Long employeeId){

        return employeerepo.findById(employeeId).orElse(null);

    }

    @GetMapping
    public List<EmployeeEntity> getMessege(@RequestParam(required = false) Integer age,
                             @RequestParam(required = false) String msg){
        return employeerepo.findAll();
    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputDto){

        return employeerepo.save(inputDto);
    }

    @PutMapping
    public String putMapping(){
        return "Hi I am from putMapping";
    }
}
