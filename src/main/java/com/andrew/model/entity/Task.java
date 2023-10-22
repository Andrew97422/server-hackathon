package com.andrew.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tasks")
@Data
public class Task {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Employer")
    private Employee employee;

    @Column(name = "Create_Date")
    private LocalDateTime createDate;

    @Column(name = "Close_Date")
    private LocalDateTime closeDate;

    @ManyToOne
    @JoinColumn(name = "ID_Template")
    private TaskTemplate taskTemplate;

    @Column(name = "Balls")
    private float balls;

    @ManyToOne
    @JoinColumn(name = "ID_Status")
    private TaskStatus taskStatus;

    @Column(name = "Activity")
    private boolean active;

    @Column(name = "Ready")
    private boolean ready;

    @Column(name = "CountTry")
    private Integer count;
}
