package com.example.demo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeAgeValidator implements ConstraintValidator<EmployeeAgeValidation , String> {
    @Override
    public boolean isValid(String inputAge, ConstraintValidatorContext constraintValidatorContext) {
        int age = Integer.parseInt(inputAge);
        return (age >= 20);
    }
}
