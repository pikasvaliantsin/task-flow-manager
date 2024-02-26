package by.it.academy.controllers;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskDto;
import by.it.academy.services.tasks.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("task/{id}")
    public ReadTaskDto getTaskById(@PathVariable UUID id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("task/{number}")
    public ReadTaskDto getTaskByPersonalNumber(@PathVariable @NotNull Integer number){
        return taskService.getTaskByPersonalNumber(number);
    }

    @GetMapping("tasks")
    public List<ReadTaskDto> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("task")
    @ResponseStatus(CREATED)
    public ReadTaskDto createTask(@Valid @RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    @DeleteMapping("task/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }

    @PutMapping("task/{id}")
    public ReadTaskDto updateTask(@PathVariable UUID id, @Valid @RequestBody CreateTaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @PatchMapping("task/{id}/priority")
    public boolean changePriority(@PathVariable UUID id, @NotBlank @RequestBody String priority) {
        return taskService.changePriority(id, priority);
    }
}