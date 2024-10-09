package org.example.dao;

import org.example.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
