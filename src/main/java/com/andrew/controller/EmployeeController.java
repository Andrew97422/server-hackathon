package com.andrew.controller;

import com.andrew.model.dto.EmployeeResponse;
import com.andrew.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Менеджер', 'Сотрудник')")
    public ResponseEntity<EmployeeResponse> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(service.getById(Integer.parseInt(id)));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Менеджер')")
    public ResponseEntity<List<EmployeeResponse>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
