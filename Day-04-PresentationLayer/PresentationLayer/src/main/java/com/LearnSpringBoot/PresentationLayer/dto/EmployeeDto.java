package com.LearnSpringBoot.PresentationLayer.dto;

import java.time.LocalDate;

public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate dateOfJoin;
    private Boolean isActive;

    public EmployeeDto(Long id, String name, String email, LocalDate dateOfJoin, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dateOfJoin = dateOfJoin;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
