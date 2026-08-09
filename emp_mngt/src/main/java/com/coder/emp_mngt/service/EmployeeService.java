package com.coder.emp_mngt.service;

import com.coder.emp_mngt.entity.Employee;
import com.coder.emp_mngt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;
    
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    public Employee getEmployeeById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Employee updateEmployee(long id, Employee employeeRequest) {

        Employee employee = repo.findById(id).orElse(null);

        //employee.setFirstName((employeeRequest.getFirstName()) == null ? employee.getFirstName() : employeeRequest.getFirstName());

        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setDesignation(employeeRequest.getDesignation());
        employee.setAddress(employeeRequest.getAddress());

        return repo.save(employee);
    }

    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }

    public Employee updateProfile(long id, Employee newProfile) {

        Employee myProfile = repo.findById(id).orElse(null);

        // myProfile.setFirstName((newProfile.getFirstName()) == null ? myProfile.getFirstName() : newProfile.getFirstName());

        myProfile.setFirstName(newProfile.getFirstName());
        myProfile.setLastName(newProfile.getLastName());
        myProfile.setEmail(newProfile.getEmail());
        myProfile.setPhone(newProfile.getPhone());
        myProfile.setAddress(newProfile.getAddress());

        return repo.save(myProfile);
    }

}
