package com.mvc.thymeleaf.service.impl;

import com.mvc.thymeleaf.dto.EmployeeRequestDto;
import com.mvc.thymeleaf.entity.Employee;
import com.mvc.thymeleaf.mapper.EmployeeMapper;
import com.mvc.thymeleaf.repository.EmployeeRepository;
import com.mvc.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        //this.employeeRepository.save(employeeRequestDto);
        Employee employee = employeeMapper.mapRequestToEmployee(employeeRequestDto);
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()) {
            employee = optional.get();
        }
        else {
            throw new RuntimeException("Employee not found for id:" +id);
        }
        return employee;
    }

    @Override
    public void updateEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee1 = employeeRepository.findById(employeeRequestDto.getId()).get();
        employee1.setFirstName(employeeRequestDto.getFirstName());
        employee1.setLastName(employeeRequestDto.getLastName());
        employee1.setEmail(employeeRequestDto.getEmail());
        employeeRepository.save(employee1);
    }
    @Override
    public void deleteById(long id) {
        this.employeeRepository.deleteById(id);
    }


}
