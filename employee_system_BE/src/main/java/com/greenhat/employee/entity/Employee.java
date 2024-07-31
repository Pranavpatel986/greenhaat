package com.greenhat.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="email cannot be blank")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @NotBlank(message="add password")
    private String password;

    private String phone;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<EmployeeRole> employeeRoles = new HashSet<>();

    private Instant created;
    private boolean enabled;

}
