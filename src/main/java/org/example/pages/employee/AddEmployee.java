package org.example.pages.employee;

import org.apache.commons.lang3.StringUtils;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.example.entities.Address;
import org.example.entities.Employee;
import org.example.model.Role;
import org.example.services.EmployeeService;
import org.w3c.dom.Text;

import javax.inject.Inject;
import static java.util.Objects.isNull;

public class AddEmployee {

    //TODO : Taking too long and can't bedug. look at this later. use entity for now
    //    @Property
    //    private EmployeeInDTO employeeInDTO = new EmployeeInDTO(null, null, new AddressInDTO());

    @Property
    private Employee employee;

    @InjectComponent("form")
    private Form form;

    @Property
    private String name;

    @Property
    private Integer age;

    @Property
    private String username;

    @Property
    private String password;

    //Address
    @Property
    private String street1;

    @Property
    private String street2;

    @Property
    private String zip;

    @Property
    private String country;

    @Inject
    private EmployeeService employeeService;

    @InjectPage
    private ListEmployees listEmployees;

    void setupRender(){

    }

    //called before the form is created
    void onPrepareFromForm(){ //naming convention is on prep from 'form name'
        if(employee == null){
            employee = new Employee();
            employee.setAddress(new Address());
        }
    }

    void onValidateFromForm(){

        //Employee Details
        if (StringUtils.isEmpty(username)) {
            form.recordError("Username can't be empty!");
        }
        if (StringUtils.isEmpty(password)) {
            form.recordError("Password can't be empty!");
        }
        if (StringUtils.isEmpty(name)) {
            form.recordError("Name can't be empty!");
        }
        if (age == null) {
            form.recordError("Age can't be empty!");
        }

        // Validate Address
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

    Object onSuccess(){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setAge(age);

        Address address = new Address();
        address.setStreet1(street1);
        address.setStreet2(street2);
        address.setZip(zip);
        address.setCountry(country);

        employee.setAddress(address);

        //By default, keep any new employee as normal employee
        employee.setRole(Role.NORMAL_EMPLOYEE);

        employeeService.save(employee);

        return listEmployees;
    }
}
