package org.example.services;

import org.example.dto.EmployeeInDTO;
import org.example.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById(Integer id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(Integer id);

    Employee update(Integer id, Employee employee);
}
