package com.coder.emp_mngt.controller;

import com.coder.emp_mngt.entity.Employee;
import com.coder.emp_mngt.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/profile")
    public Employee myProfile(@PathVariable long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/profile")
    public Employee updateProfile(@PathVariable long id, @RequestBody Employee newProfile) {
        return service.updateProfile(id, newProfile);
    }

}