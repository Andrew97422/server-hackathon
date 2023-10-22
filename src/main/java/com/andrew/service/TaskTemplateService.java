package com.andrew.service;

import com.andrew.model.dto.TaskTemplateRequest;
import com.andrew.model.dto.TaskTemplateResponse;
import com.andrew.model.entity.TaskTemplate;
import com.andrew.repository.TaskTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskTemplateService {

    private final TaskTemplateRepository taskTemplateRepository;

    @Transactional(readOnly = true)
    public TaskTemplateResponse getById(int i) {
        var taskTemplate = taskTemplateRepository.getReferenceById(i);
        return TaskTemplateResponse.builder().name(taskTemplate.getName())
                .id(taskTemplate.getId()).template(taskTemplate.getTemplate()).build();
    }

    @Transactional(readOnly = true)
    public List<TaskTemplateResponse> getAll() {
        return taskTemplateRepository.findAll().stream().map(i ->
                TaskTemplateResponse.builder().id(i.getId())
                .name(i.getName()).template(i.getTemplate()).build())
                .collect(Collectors.toList());
    }

    @Transactional
    public Integer addNew(TaskTemplateRequest request) {
        var taskTemplate = TaskTemplate.builder().name(request.getName())
                .template(request.getTemplate()).build();
        taskTemplateRepository.save(taskTemplate);
        return taskTemplate.getId();
    }
}
