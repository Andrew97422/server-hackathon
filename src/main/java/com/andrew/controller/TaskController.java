package com.andrew.controller;

import com.andrew.model.dto.TaskRegisterRequest;
import com.andrew.model.dto.TaskResponse;
import com.andrew.model.entity.Employee;
import com.andrew.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @PreAuthorize("hasAuthority('Менеджер')")
    @PostMapping
    public ResponseEntity<Integer> createTask(
            @AuthenticationPrincipal Employee employee,
            @RequestBody TaskRegisterRequest request
            ) {
        return ResponseEntity.ok(taskService.createNewTask(employee, request));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('Менеджер', 'Сотрудник')")
    public ResponseEntity<TaskResponse> getById(
        @PathVariable String id
    ) {
        return ResponseEntity.ok(taskService.getById(Integer.parseInt(id)));
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('Менеджер')")
    public ResponseEntity<List<TaskResponse>> getAll() {
        return ResponseEntity.ok(taskService.getAll());
    }
}
