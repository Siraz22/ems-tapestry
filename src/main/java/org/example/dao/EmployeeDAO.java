package org.example.dao;

import org.example.entities.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Integer id);

    Employee save(Employee employee);

    void deleteByEmployee(Employee employee);

    Employee updateEmployee(Employee employee);
}
