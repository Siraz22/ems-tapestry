package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name="permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "permissions")
    List<EmployeeHasPermission> employeeHasPermissions;


}
