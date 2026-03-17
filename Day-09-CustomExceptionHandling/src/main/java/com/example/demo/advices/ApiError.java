package com.example.demo.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String messege;
    private List<String> subErrors;


}
