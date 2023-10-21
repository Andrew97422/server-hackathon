package com.andrew.model.entity;

import com.andrew.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Employers")
public class Employee {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIO")
    private String fio;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "ID_Role")
    @Enumerated
    private Role role;

    @JoinColumn(name = "ID_Restaurant")
    @ManyToOne
    private Restaurant restaurant_id;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String Password;
}
