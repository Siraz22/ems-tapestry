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

    //TODO : using hardcoded permissions. can improve this
    @Override
    public boolean employeeHasPermission(String username, String hardcodedPermission) {
        Employee employee = employeeService.findByUsername(username);
        return employee.getEmployeeHasPermissions().stream()
                .anyMatch(employeeHasPermission -> employeeHasPermission.getPermission().getName().equals(hardcodedPermission));
    }

    @Override
    public boolean employeeHasPermission(String username, Permission permission) {
        Employee employee = employeeService.findByUsername(username);
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
