package com.andrew.controller;

import com.andrew.model.dto.TaskTemplateRequest;
import com.andrew.model.dto.TaskTemplateResponse;
import com.andrew.service.TaskTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@PreAuthorize(value = "hasAuthority('Менеджер')")
@RequestMapping("/api/v1/task-template")
public class TaskTemplateController {

    private final TaskTemplateService taskTemplateService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskTemplateResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(taskTemplateService.getById(Integer.parseInt(id)));
    }

    @GetMapping
    public ResponseEntity<List<TaskTemplateResponse>> getAll() {
        return ResponseEntity.ok(taskTemplateService.getAll());
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody TaskTemplateRequest request) {
        return ResponseEntity.ok(taskTemplateService.addNew(request));
    }
}
