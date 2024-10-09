package org.example.pages.employee;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Address;
import org.example.entities.Employee;
import org.example.services.EmployeeService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/custom.css")
public class ListEmployees {

    @Property
    List<Employee> employees;

    @Property
    Employee currEmployee;

    @Inject
    private EmployeeService employeeService;

    void setupRender(){
        employees = employeeService.findAll();
    }
}
