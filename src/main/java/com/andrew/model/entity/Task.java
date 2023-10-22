package com.andrew.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Tasks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "counttry")
    private Integer countTry;
}
