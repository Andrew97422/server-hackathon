package com.andrew.service;

import com.andrew.model.dto.TaskRegisterRequest;
import com.andrew.model.dto.TaskResponse;
import com.andrew.model.entity.Employee;
import com.andrew.model.entity.Task;
import com.andrew.repository.TaskRepository;
import com.andrew.repository.TaskTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskTemplateRepository taskTemplateRepository;

    @Transactional
    public Integer createNewTask(Employee employee, TaskRegisterRequest request) {
        var task = Task.builder().employee(employee).createDate(request.getCreateDate())
                .closeDate(request.getCloseDate()).balls(request.getBalls())
                .active(LocalDateTime.now().isAfter(request.getCreateDate())
                        && LocalDateTime.now().isBefore(request.getCloseDate()))
                .ready(false).count(0).build();
        var taskTemplate = taskTemplateRepository.getReferenceById(request.getTaskTemplate());
        task.setTaskTemplate(taskTemplate);
        taskRepository.save(task);
        return task.getId();
    }

    @Transactional(readOnly = true)
    public TaskResponse getById(int i) {
        var task = taskRepository.getReferenceById(i);
        return TaskResponse.builder().employeeId(task.getEmployee().getId())
                .createDate(task.getCreateDate()).closeDate(task.getCloseDate())
                .taskTemplate(task.getTaskTemplate().getId()).balls(task.getBalls())
                .taskStatus(task.getTaskStatus().getId()).ready(task.isReady())
                .count(task.getCount()).active(task.isActive()).build();
    }


    @Transactional(readOnly = true)
    public List<TaskResponse> getAll() {
        return taskRepository.findAll().stream().map(task -> TaskResponse.builder()
                .employeeId(task.getEmployee().getId())
                .createDate(task.getCreateDate()).closeDate(task.getCloseDate())
                .taskTemplate(task.getTaskTemplate().getId()).balls(task.getBalls())
                .taskStatus(task.getTaskStatus().getId()).ready(task.isReady())
                .count(task.getCount()).active(task.isActive()).build()).collect(Collectors.toList());
    }
}
