package com.andrew.service;

import com.andrew.model.dto.EmployeeResponse;
import com.andrew.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public EmployeeResponse getById(int i) {
        var employee1 = employeeRepository.getReferenceById(i);
        return EmployeeResponse.builder()
                .fio(employee1.getFio()).phone(employee1.getPhone())
                .restaurantId(employee1.getRestaurantId().getId())
                .login(employee1.getLogin()).password(employee1.getPassword())
                .role(employee1.getRole().getName())
                .build();
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream().map(i -> EmployeeResponse.builder()
                        .role(String.valueOf(i.getRole())).fio(i.getFio()).login(i.getLogin()).phone(i.getPhone())
                        .restaurantId(1).password(i.getPassword()).build())
                .collect(Collectors.toList());
    }
}
