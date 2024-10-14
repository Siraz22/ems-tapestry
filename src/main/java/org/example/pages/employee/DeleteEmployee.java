package org.example.pages.employee;

import org.apache.tapestry5.annotations.Property;
import org.example.entities.Employee;
import org.example.services.EmployeeService;

import javax.inject.Inject;

public class DeleteEmployee {
    @Inject
    private EmployeeService employeeService;

    @Property
    Employee employee;

    void onActivate(Integer employeeId){
        employee = this.employeeService.findById(employeeId);
    }
}
