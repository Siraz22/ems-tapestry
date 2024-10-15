package org.example.pages.employee;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Employee;
import org.example.services.EmployeeService;

import javax.inject.Inject;

@Import(stylesheet = "context:css/custom.css")
public class ViewEmployee {

    @Property
    private Integer employeeId;

    @Property
    private Employee employee;

    @Inject
    private EmployeeService employeeService;

    void onActivate(Integer employeeId) {
        this.employeeId = employeeId;
        this.employee = employeeService.findById(employeeId);
    }
}
