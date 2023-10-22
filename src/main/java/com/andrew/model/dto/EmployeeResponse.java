package com.andrew.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeResponse {

    private String fio;

    private String phone;

    private String role;

    private Integer restaurantId;

    private String login;

    private String password;
}
