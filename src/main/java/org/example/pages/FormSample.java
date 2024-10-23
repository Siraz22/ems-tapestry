package org.example.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;

public class FormSample {
    @Property
    private String name;

    @InjectComponent("nameForm")
    private Form nameForm;

    @Log
    void onValidateFromNameForm(){
        if(name == null){
            System.out.println("name is null");
        }
        else{
            System.out.println("name is "+name);
        }
    }

    Object onSuccessFromNameForm(){
        return this;
    }
}
