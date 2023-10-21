package com.andrew.auth;

import com.andrew.model.entity.Restaurant;
import com.andrew.model.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String fio;

    private String phone;

    private String role;

    private Integer restaurant_id;

    private String login;

    private String password;
}
