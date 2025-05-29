package com.example.employee_portal.service;

import com.example.employee_portal.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    public void addEmployee(Employee employee) {
        System.out.println("Adding employee: " + employee.getName() + ", Position: " + employee.getPosition());
    }

    public void deleteEmployee(Long id) {
        System.out.println("Deleting employee with ID: " + id);
    }
}
