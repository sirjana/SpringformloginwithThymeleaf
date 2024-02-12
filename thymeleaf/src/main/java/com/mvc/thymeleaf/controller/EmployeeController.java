package com.mvc.thymeleaf.controller;

import com.mvc.thymeleaf.dto.EmployeeRequestDto;
import com.mvc.thymeleaf.entity.Employee;
import com.mvc.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "employees";
    }
    @GetMapping("/save/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        //create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }
    //Modelattribute is used to bind form data from the view to the model.
    @PostMapping("/save/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") EmployeeRequestDto employeeRequestDto){
        employeeService.saveEmployee(employeeRequestDto);
        return "redirect:/employees";
    }

    @GetMapping("/showForm/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("/update/updateEmployee")
    public String processUpdateEmployee(@ModelAttribute("employee") EmployeeRequestDto employeeRequestDto) {
        employeeService.updateEmployee(employeeRequestDto);
        return "redirect:/employees";
    }

    @GetMapping("/delete/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value="id") Long id) {
        this.employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
