package com.example.employee_portal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private final Long id;
    private final String name;
    private final String position;

    public Employee() {
        this.id = null; // Default constructor for JPA
        this.name = null;
        this.position = null;
    }

    public Employee(Long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public Long getId() {
        return id;
    }
}
