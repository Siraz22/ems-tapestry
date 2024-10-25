package org.example.services.impl;

import org.example.entities.Employee;
import org.example.entities.Permission;
import org.example.services.EmployeeHasPermissionService;
import org.example.services.EmployeeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class EmployeeHasPermissionServiceImpl implements EmployeeHasPermissionService {

    @Inject
    private EmployeeService employeeService;

    @Override
    public boolean employeeHasPermission(Integer employeeId, Permission permission) {
        Employee employee = employeeService.findById(employeeId);
        return employeeHasPermission(employee, permission);
    }

    @Override
    public boolean employeeHasPermission(Employee employee, Permission permission) {
        return hasPermission(employee, permission);
    }

    private boolean hasPermission(Employee employee, Permission permission) {
        return employee.getEmployeeHasPermissions().stream()
                .anyMatch(employeeHasPermission -> employeeHasPermission.getPermission().equals(permission));
    }
}
