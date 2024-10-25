package org.example.pages.employee;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.entities.Employee;
import org.example.services.EmployeeService;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Inject;

public class EditEmployee {

    @Property
    private Employee employee;

    @Property
    private Integer employeeId;

    @Property
    private String street1;

    @Property
    private String street2;

    @Property
    private String zip;

    @Property
    private String country;

    @InjectComponent("form")
    private Form form;

    @InjectComponent("name")
    private TextField nameField;

    @InjectComponent("age")
    private TextField ageField;

    @InjectPage
    private ListEmployees listEmployees;

    @Inject
    private EmployeeService employeeService;

    void onActivate(Integer employeeId){
        this.employeeId = employeeId;
        this.employee = employeeService.findById(employeeId);
        if (employee != null && employee.getAddress() != null) {
            street1 = employee.getAddress().getStreet1();
            street2 = employee.getAddress().getStreet2();
            zip = employee.getAddress().getZip();
            country = employee.getAddress().getCountry();
        }
    }

    Integer onPassivate(){
        return employeeId;
    }

    void onPrepareForRender() {
        if (form.isValid()) {
            employee = employeeService.findById(employeeId);
        }
    }

    void onValidateFromForm() {
        if (employee == null) {
            form.recordError("Employee data is null");
        }

        if (StringUtils.isEmpty(employee.getName())) {
            form.recordError(nameField, "Name can't be empty!");
        }
        if (employee.getAge() == null) {
            form.recordError(ageField, "Age can't be empty!");
        }

        if (StringUtils.isEmpty(street1)) {
            form.recordError("Street 1 can't be empty!");
        }
        if (StringUtils.isEmpty(zip)) {
            form.recordError("Zip code can't be empty!");
        }
        if (StringUtils.isEmpty(country)) {
            form.recordError("Country can't be empty!");
        }
    }

    Object onSuccess() {
        employee.getAddress().setStreet1(street1);
        employee.getAddress().setStreet2(street2);
        employee.getAddress().setZip(zip);
        employee.getAddress().setCountry(country);

        employeeService.update(employeeId, employee);
        return listEmployees;
    }
}
