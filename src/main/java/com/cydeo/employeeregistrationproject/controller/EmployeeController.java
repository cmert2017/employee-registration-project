package com.cydeo.employeeregistrationproject.controller;

import com.cydeo.employeeregistrationproject.bootstrap.DataGenerator;
import com.cydeo.employeeregistrationproject.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register")
    public String createEmployee(Model model){

        model.addAttribute("employee",new Employee());
        model.addAttribute("states", DataGenerator.getAllStates());

        return "employee/employee-create";
    }

    @PostMapping ("/list")
    public String employeeList(@ModelAttribute("employee") Employee employee, Model model){

        DataGenerator.saveEmployee(employee);
        model.addAttribute("employees",DataGenerator.readAllEmployees());

        return "employee/employee-list";
    }



}
