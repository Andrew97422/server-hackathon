package com.andrew.auth;

import com.andrew.model.entity.Employee;
import com.andrew.model.entity.Restaurant;
import com.andrew.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUtils {

    private final PasswordEncoder passwordEncoder;

    public Employee mapToEntity(RegisterRequest request, Restaurant restaurant, Role role) {
        return Employee.builder().fio(request.getFio())
                .restaurantId(restaurant)
                .phone(request.getPhone()).login(request.getLogin())
                .Password(passwordEncoder.encode(request.getPassword()))
                .role(role).build();
    }
}
