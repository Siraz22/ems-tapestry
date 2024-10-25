package org.example.pages.employee;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Employee;
import org.example.services.EmployeeHasPermissionService;
import org.example.services.EmployeeService;

import javax.inject.Inject;
import java.util.List;

@Import(stylesheet = "context:css/custom.css")
public class ListEmployees {

    @Property
    List<Employee> employees;

    @Property
    Employee currEmployee;

    @Property
    @Persist
    private String username;

    @Property
    private boolean hasEditAccess;

    @Inject
    private EmployeeService employeeService;

    @Inject
    private EmployeeHasPermissionService employeeHasPermissionService;

    void setupRender(){
        System.out.println("logged in user is "+username);
        hasEditAccess = employeeHasPermissionService.employeeHasPermission(username, "edit_employee");
        employees = employeeService.findAll();

        System.out.println("access for edit is "+hasEditAccess);
    }

    public void onActivate(String username){
        this.username = username;
    }

    void onActionFromDeleteEmployeeById(Integer employeeId){
        employeeService.deleteById(employeeId);
    }

}
