package org.example.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ref_address")
    private Address address;

    @Column(name = "password")
    private String password;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeHasPermission> employeeHasPermissions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
