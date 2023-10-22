package com.andrew.service;

import com.andrew.model.dto.TaskRegisterRequest;
import com.andrew.model.dto.TaskResponse;
import com.andrew.model.entity.Employee;
import com.andrew.model.entity.Task;
import com.andrew.repository.TaskRepository;
import com.andrew.repository.TaskTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskTemplateRepository taskTemplateRepository;

    public Integer createNewTask(Employee employee, TaskRegisterRequest request) {
        var task = new Task();
        task.setEmployee(employee);
        task.setCreateDate(request.getCreateDate());
        task.setCloseDate(request.getCloseDate());
        var taskTemplate = taskTemplateRepository.getReferenceById(request.getTaskTemplate());
        task.setTaskTemplate(taskTemplate);
        task.setBalls(request.getBalls());
        task.setActive(LocalDateTime.now().isAfter(request.getCreateDate())
                && LocalDateTime.now().isBefore(request.getCloseDate()));
        task.setReady(false);
        task.setCount(0);
        taskRepository.save(task);
        return task.getId();
    }

    public TaskResponse getById(int i) {
        var task = taskRepository.getReferenceById(i);
        return TaskResponse.builder().employeeId(task.getEmployee().getId())
                .createDate(task.getCreateDate()).closeDate(task.getCloseDate())
                .taskTemplate(task.getTaskTemplate().getId()).balls(task.getBalls())
                .taskStatus(task.getTaskStatus().getId()).ready(task.isReady())
                .count(task.getCount()).active(task.isActive()).build();
    }


    public List<TaskResponse> getAll() {
        return taskRepository.findAll().stream().map(task -> TaskResponse.builder()
                .employeeId(task.getEmployee().getId())
                .createDate(task.getCreateDate()).closeDate(task.getCloseDate())
                .taskTemplate(task.getTaskTemplate().getId()).balls(task.getBalls())
                .taskStatus(task.getTaskStatus().getId()).ready(task.isReady())
                .count(task.getCount()).active(task.isActive()).build()).collect(Collectors.toList());
    }
}
