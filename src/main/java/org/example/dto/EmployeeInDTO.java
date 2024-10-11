package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInDTO {
    String name;
    String age;
    AddressInDTO addressInDTO;

    public EmployeeInDTO(String name, String age, AddressInDTO addressInDTO) {
        this.name = name;
        this.age = age;
        this.addressInDTO = addressInDTO;
    }

    public EmployeeInDTO(){

    }
}
