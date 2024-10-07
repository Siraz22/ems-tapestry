package org.example.pages;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.example.entities.Address;

public class ViewEmployee {
    @Property
    @Persist
    private String name;

    @Property
    @Persist
    private Integer age;

    @Property
    @Persist
    private Address address;

    @Log
    void setEmployeeDetails(String name, Integer age, Address address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
