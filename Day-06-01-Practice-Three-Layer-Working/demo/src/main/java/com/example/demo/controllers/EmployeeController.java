package com.example.demo.controllers;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.EmployeEntity;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "employeeId") Long id){
        Optional<EmployeeDto>employeeDto = employeeService.getEmployeeById(id);
        return employeeDto.map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees(@RequestParam (required = false , name = "inputAge") Integer age,
                                               @RequestParam (required = false ) String sortBy){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto inputEmployee){
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDto updateEmployeeById(@RequestBody EmployeeDto employeeDto , @PathVariable Long employeeId){
        return employeeService.updateEmployeeById(employeeDto , employeeId);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployee(@PathVariable Long employeeId){
        return employeeService.deleteEmployee(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDto updatePartialEmployeeById(@RequestBody Map<String , Object> updates,
                                                 @PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(employeeId , updates);
    }

}
