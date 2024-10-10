package org.example.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.entities.Employee;
import org.example.pages.employee.ListEmployees;
import org.example.services.EmployeeService;

import javax.inject.Inject;
import java.util.List;

@Import(stylesheet = "context:css/custom.css")
public class Login {
    @Property
    private String username;

    @Property
    private String password;

    @InjectComponent("form")
    private Form form;

    @InjectComponent("username")
    private TextField usernameField;

    @InjectComponent("password")
    private TextField passwordField;

    @InjectPage
    private ListEmployees listEmployees;

    @Inject
    private EmployeeService employeeService;

    void setupRender(){
        username="admin";
        password="password123";
        List<Employee> employees = employeeService.findAll();
        System.out.println(employees);
    }

    void onValidateFromForm(){
        if(username == null || username.isEmpty()){
            form.recordError(usernameField, "Username can't be empty!");
        }
        else if(!"admin".equals(username)){
            form.recordError(usernameField,"Wrong username!");
        }

        if(password == null || password.isEmpty()){
            form.recordError(passwordField, "Password can't be empty!");
        }
        else if(!"password123".equals(password)){
            form.recordError(passwordField, "Password is wrong");
        }
    }

    Object onSuccess(){
        return listEmployees;
    }
}


