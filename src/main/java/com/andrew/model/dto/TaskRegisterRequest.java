package com.andrew.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskRegisterRequest {
    private LocalDateTime createDate;
    private LocalDateTime closeDate;
    private Integer taskTemplate;
    private float balls;
}
