package com.mvc.thymeleaf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
