package com.mvc.thymeleaf.mapper;

import com.mvc.thymeleaf.dto.EmployeeRequestDto;
import com.mvc.thymeleaf.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee mapRequestToEmployee(EmployeeRequestDto employeeRequestDto){
        Employee employee1 = new Employee();
        employee1.setFirstName(employeeRequestDto.getFirstName());
        employee1.setLastName(employeeRequestDto.getLastName());
        employee1.setEmail(employeeRequestDto.getEmail());
        return employee1;
    }
}
