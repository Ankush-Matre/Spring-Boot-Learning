package com.cricket.bcci.Cricket.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CricketerDTO {

    private Integer id;

    private String name;

    private Integer age;

    private Boolean active;

    private String country;

    private LocalDate dateOfDebue;

    private Double salary;

}
