package org.example.pages;

import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.entities.Employee;
import org.example.exception.BadRequestException;
import org.example.pages.employee.ListEmployees;
import org.example.services.AuthenticationService;
import org.example.services.EmployeeService;

import javax.inject.Inject;
import java.util.List;

@Import(stylesheet = "context:css/custom.css")
public class Login {
    @Property
    private String username;

    @Property
    private String password;

    @InjectComponent
    private Form loginForm;

    @InjectPage
    private ListEmployees listEmployees;

    @Inject
    private EmployeeService employeeService;

    @Inject
    private AuthenticationService authenticationService;

    void setupRender(){
    }

    void onValidateFromLoginForm(){
        if(username == null || username.isEmpty()){
            loginForm.recordError("Username can't be empty!");
        }

        if(password == null || password.isEmpty()){
            loginForm.recordError( "Password can't be empty!");
        }

        try {
            authenticationService.validatePassword(username, password);
        }
        catch(BadRequestException bre){
            loginForm.recordError("Login details are incorrect. Try again");
        }
    }

    @Log
    public Object onSuccessFromLoginForm(){
        System.out.println("Successful login");
        return listEmployees;
    }
}


