package org.example.services.impl;

import org.example.dao.EmployeeDAO;
import org.example.entities.Address;
import org.example.entities.Employee;
import org.example.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDAO.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }
}
