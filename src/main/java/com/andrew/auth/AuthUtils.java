package com.andrew.auth;

import com.andrew.model.entity.Employee;
import com.andrew.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUtils {

    private final PasswordEncoder passwordEncoder;

    public Employee mapToEntity(RegisterRequest request) {
        return Employee.builder().fio(request.getFio())
                .phone(request.getPhone()).login(request.getLogin())
                .Password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
    }
}
