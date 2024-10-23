package org.example.services.impl;

import org.example.entities.Employee;
import org.example.exception.BadRequestException;
import org.example.services.AuthenticationService;
import org.example.services.EmployeeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Inject
    private EmployeeService employeeService;

    @Override
    public void validatePassword(String username, String password){
        Employee employee = employeeService.findByUsername(username);
        if(isNull(employee) || (!employee.getPassword().equals(password))){
            throw new BadRequestException("Logn info is incorrect");
        }
    }
}
