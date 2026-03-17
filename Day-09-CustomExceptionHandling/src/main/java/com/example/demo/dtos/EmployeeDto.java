package com.example.demo.dtos;

import com.example.demo.annotations.EmployeeAgeValidation;
import com.example.demo.annotations.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

//    @NotNull(message = "This is not valid name")
    //this annotation is used to check not null
    //@NotBlank(message = "Blank name is Provided")
    //@Size(min = 2 , max = 10 , message = "No of Characters should be in range [3 , 10]")
    private String name;

//    @Email(message = "Email should be valid")
    private String email;

//    @Pattern(regexp = "^(USER|ADMIN)$" , message = "User or Admin")
//    @NotBlank(message = "Role should not be blanck")
//    @EmployeeRoleValidation //This is the custom annotations which is used to create our own logic
                              //for validation to new things
    private String role;

//    @Max(value = 80, message = "The age of the employee should be greater than 80")
//    @EmployeeAgeValidation
    private Integer age;
    private LocalDate dateOfJoining;
//    @JsonProperty("isActive")
    private Boolean isActive;
}
