package org.example.pages.employee;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.entities.Employee;
import org.example.services.EmployeeService;

import javax.inject.Inject;

import static java.util.Objects.isNull;

public class EditEmployee {

    @Inject
    private EmployeeService employeeService;

    @InjectComponent("form")
    private Form form;

    @InjectComponent("name")
    private TextField nameField;

    @InjectComponent("age")
    private TextField ageField;

    @InjectPage
    private ListEmployees listEmployees;

    @Property
    private Employee employee;

    @Property
    private Integer employeeId;

    void onActivate(Integer employeeId){
        this.employeeId = employeeId;
        this.employee = employeeService.findById(employeeId);
    }

    Integer onPassivate(){
        return employeeId;
    }

    void onPrepareForRender(){
        if(form.isValid()){
            employee = employeeService.findById(employeeId);
        }
    }

    void onValidateFromForm(){
        if(isNull(employee)){
            form.recordError("employee data is somehow null");
        }

        //validate Employee
        if(StringUtils.isEmpty(employee.getName())){
            form.recordError(nameField, "Name can't be empty!");
        }
        if(isNull(employee.getAge())){
            form.recordError(ageField,"Age can't be empty");
        }

        //validate Address
        if (StringUtils.isEmpty(employee.getAddress().getStreet1())) {
            form.recordError("Street 1 can't be empty!");
        }
        if (StringUtils.isEmpty(employee.getAddress().getStreet2())) {
            form.recordError("Street 2 can't be empty!");
        }
        if (StringUtils.isEmpty(employee.getAddress().getZip())) {
            form.recordError("Zip code can't be empty!");
        }
        if (StringUtils.isEmpty(employee.getAddress().getCountry())) {
            form.recordError("Country can't be empty!");
        }
    }

    Object onSuccess(){
        employeeService.update(employeeId, employee);
        return listEmployees;
    }
}
