package org.example.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "employee_has_permission")
public class EmployeeHasPermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ref_permission")
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "ref_employee")
    private Employee employee;
}