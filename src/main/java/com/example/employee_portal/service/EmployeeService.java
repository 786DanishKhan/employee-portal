package com.example.employee_portal.service;

import com.example.employee_portal.model.Employee;
import com.example.employee_portal.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        System.out.println("Adding employee: " + employee.getName() + ", Position: " + employee.getPosition());
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        System.out.println("Fetching all employees");
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    public int countEmployees() {
        System.out.println("Counting employees");
        return (int) employeeRepository.count();
    }
}
