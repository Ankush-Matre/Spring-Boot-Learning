package com.example.demo.controllers;

import com.example.demo.dtos.EmployeeDto;
import com.example.demo.entities.EmployeEntity;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
        return employeeDto
                .map(employeeDto1 -> ResponseEntity.ok(employeeDto1))
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with Id" + id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(@RequestParam (required = false , name = "inputAge") Integer age,
                                                             @RequestParam (required = false ) String sortBy){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> createNewEmployee(@RequestBody @Valid EmployeeDto inputEmployee){
        EmployeeDto savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDto> updateEmployeeById(@RequestBody @Valid EmployeeDto employeeDto , @PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDto , employeeId));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long employeeId){
        boolean gotDeleted = employeeService.deleteEmployee(employeeId);
        if(gotDeleted){
            return ResponseEntity.ok(true);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDto updatePartialEmployeeById(@RequestBody Map<String , Object> updates,
                                                 @PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(employeeId , updates);
    }

}
