package com.mvc.thymeleaf.service;

import com.mvc.thymeleaf.dto.EmployeeRequestDto;
import com.mvc.thymeleaf.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(EmployeeRequestDto employeeRequestDto);

    Employee getEmployeeById(long id);

    public void updateEmployee(EmployeeRequestDto employeeRequestDto);
    void deleteById(long id);
}
