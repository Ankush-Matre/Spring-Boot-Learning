package com.LearnSpringBoot.PresentationLayer.controller;

import com.LearnSpringBoot.PresentationLayer.dto.EmployeeDto;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

//    @GetMapping(path = "/getSecretmessage")
//    public String getMessage(){
//        return "I am Hacker";
//    }

    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployeeData(@PathVariable Long employeeId){

        return new EmployeeDto(employeeId , "Ankush" , "ankushmatre1234@gmail.com" , LocalDate.of(2026 , 12 , 12) , true);

    }

    @GetMapping
    public String getMessege(@RequestParam(required = false) Integer age,
                             @RequestParam(required = false) String msg){
        return "" + age + " " + msg;
    }

    @PostMapping
    public EmployeeDto createEmployee(@RequestBody EmployeeDto inputDto){
        inputDto.setId(100L);
        return inputDto;
    }

    @PutMapping
    public String putMapping(){
        return "Hi I am from putMapping";
    }
}
