package com.andrew.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private Integer employeeId;
    private LocalDateTime createDate;
    private LocalDateTime closeDate;
    private Integer taskTemplate;
    private float balls;
    private Integer taskStatus;
    private boolean ready;
    private Integer count;
    private boolean active;
}
