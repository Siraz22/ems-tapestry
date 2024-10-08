package org.example.pages.employee;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Address;
import org.example.entities.Employee;

import java.util.ArrayList;
import java.util.List;

@Import(stylesheet = "context:css/custom.css")
public class ListEmployees {

    @Property
    List<Employee> employees;

    @Property
    Employee currEmployee;

    void setupRender(){
        employees = createDummyEmployeeList();
    }

    public static List<Employee> createDummyEmployeeList() {
        List<Employee> employees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("John Doe");
        emp1.setAge(30);
        Address address1 = new Address();
        address1.setStreet1("123 Main St");
        address1.setStreet2("Apt 4B");
        address1.setZip("12345");
        address1.setCountry("USA");
        emp1.setAddress(address1);

        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("Jane Smith");
        emp2.setAge(25);
        Address address2 = new Address();
        address2.setStreet1("456 Elm St");
        address2.setStreet2("");
        address2.setZip("67890");
        address2.setCountry("Canada");
        emp2.setAddress(address2);

        Employee emp3 = new Employee();
        emp3.setId(3);
        emp3.setName("Michael Johnson");
        emp3.setAge(40);
        Address address3 = new Address();
        address3.setStreet1("789 Oak St");
        address3.setStreet2("Suite 100");
        address3.setZip("54321");
        address3.setCountry("UK");
        emp3.setAddress(address3);

        Employee emp4 = new Employee();
        emp4.setId(4);
        emp4.setName("Emily Davis");
        emp4.setAge(35);
        Address address4 = new Address();
        address4.setStreet1("321 Pine St");
        address4.setStreet2("Apt 12");
        address4.setZip("87654");
        address4.setCountry("Australia");
        emp4.setAddress(address4);

        Employee emp5 = new Employee();
        emp5.setId(5);
        emp5.setName("David Brown");
        emp5.setAge(28);
        Address address5 = new Address();
        address5.setStreet1("654 Cedar St");
        address5.setStreet2("Floor 2");
        address5.setZip("90876");
        address5.setCountry("New Zealand");
        emp5.setAddress(address5);

        Employee emp6 = new Employee();
        emp6.setId(6);
        emp6.setName("Sophia Wilson");
        emp6.setAge(45);
        Address address6 = new Address();
        address6.setStreet1("987 Maple St");
        address6.setStreet2("Penthouse");
        address6.setZip("13579");
        address6.setCountry("Germany");
        emp6.setAddress(address6);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);

        return employees;
    }
}
