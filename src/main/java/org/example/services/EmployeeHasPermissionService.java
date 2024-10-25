package org.example.services;

import org.example.entities.Employee;
import org.example.entities.Permission;

import java.util.List;

public interface EmployeeHasPermissionService {
    boolean employeeHasPermission(String username, String hardcodedPermission);

    boolean employeeHasPermission(String username, Permission permission);

    boolean employeeHasPermission(Employee employee, Permission permission);
}
