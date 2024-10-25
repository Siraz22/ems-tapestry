package org.example.pages.employee;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Address;
import org.example.entities.Employee;
import org.example.entities.Permission;
import org.example.services.EmployeeHasPermissionService;
import org.example.services.EmployeeService;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/custom.css")
public class ListEmployees {

    @Property
    List<Employee> employees;

    @Property
    Employee currEmployee;

    @Property
    private boolean hasEditAccess;

    @Inject
    private EmployeeService employeeService;

    @Inject
    private EmployeeHasPermissionService employeeHasPermissionService;

    @Inject
    private HttpSession session;

    void setupRender(){

        String username = (String) session.getAttribute("loggedInUser");

//        hasEditAccess = employeeHasPermissionService.employeeHasPermission()
        employees = employeeService.findAll();
    }

    void onActionFromDeleteEmployeeById(Integer employeeId){
        employeeService.deleteById(employeeId);
    }

}
