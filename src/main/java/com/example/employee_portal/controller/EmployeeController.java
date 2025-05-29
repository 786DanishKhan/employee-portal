package com.example.employee_portal.controller;

import com.example.employee_portal.model.Employee;
import com.example.employee_portal.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    // Define endpoints for employee-related operations here
    // For example, you can add methods to handle CRUD operations for employees

    // Example endpoint
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        // return employeeService.getAllEmployees();
        //return List.of("John Doe", "Jane Smith", "Alice Johnson");
        return getEmployees();
    }

    private static List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "John Doe", "Software Engineer"),
                new Employee(2L, "Jane Smith", "Project Manager"),
                new Employee(3L, "Alice Johnson", "Data Analyst"));
    }

    // Add more methods as needed for your application

    // Example method to get an employee by ID
    @GetMapping("/employees/{id}")

    public Employee getEmployeeById(@PathVariable Long id) {
        // return employeeService.getEmployeeById(id);
        return getEmployees().stream().
                filter(employee -> employee.getId().equals(id)).
                findFirst().
                orElse(null);
    }

    // endpoint to count employees
    @GetMapping("/employees/count")
    public int countEmployees() {
        // return employeeService.countEmployees();
        return getEmployees().size();
    }

    // endpoint to get employee names
    @GetMapping("/employees/names")
    public List<String> getEmployeeNames() {
        // return employeeService.getEmployeeNames();
        return getEmployees().stream()
                .map(Employee::getName)
                .toList();
    }

    // endpoint to get employee positions
    @GetMapping("/employees/positions")
    public List<String> getEmployeePositions() {
        // return employeeService.getEmployeePositions();
        return getEmployees().stream()
                .map(Employee::getPosition)
                .toList();
    }

    //additional endpoints can be added here as needed
    // For example, you can add methods to handle adding, updating, or deleting employees
    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);

    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

