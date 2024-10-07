package org.example.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.entities.Address;

/** A page class (automatically associated with the template file of the same name). */
public class Login {
    @Property
    private String username;

    @Property
    private String password;

    @InjectComponent("loginForm")
    private Form loginForm;

    @InjectComponent("username")
    private TextField usernameField;

    @InjectComponent("password")
    private TextField passwordField;

    @InjectPage
    private ViewEmployee viewEmployee;

    void onValidateFromLoginForm(){
        if(username == null || username.isEmpty()){
            loginForm.recordError(usernameField, "Username can't be empty!");
        }
        if(password == null || password.isEmpty()){
            loginForm.recordError(passwordField, "Password can't be empty!");
        }

        if(!"admin".equals(username)){
            loginForm.recordError(usernameField,"Wrong username!");
        }
        if(!"password123".equals(password)){
            loginForm.recordError(passwordField, "Password is wrong");
        }
    }

    Object onSuccess(){
        Address address = new Address();
        address.setCountry("India");
        address.setStreet1("street 1");
        address.setStreet2("street 2");
        address.setZip("10101");
        viewEmployee.setEmployeeDetails("siraz",25,address);
        return viewEmployee;
    }
}


