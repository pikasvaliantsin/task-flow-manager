package by.it.academy.controllers;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskResponse;
import by.it.academy.services.tasks.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("task/{id}")
    @ResponseStatus(OK)
    public ReadTaskResponse getTask(@PathVariable UUID id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("tasks")
    @ResponseStatus(OK)
    public List<ReadTaskResponse> getTasks() {
        return taskService.readTasks();
    }

    @PostMapping("task")
    @ResponseStatus(CREATED)
    public ReadTaskResponse createTask(@Valid @RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    @DeleteMapping("task/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTask(@PathVariable UUID id) {
        taskService.deleteTask(id);
    }

    @PutMapping("task/{id}")
    @ResponseStatus(OK)
    public ReadTaskResponse updateTask(@PathVariable UUID id, @Valid @RequestBody CreateTaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @PatchMapping("task/{id}/status")
    @ResponseStatus(OK)
    public void changeStatus(@PathVariable UUID id, @NotBlank @RequestBody String status) {
        taskService.changeStatus(id, status);
    }

    @PatchMapping("task/{id}/priority")
    @ResponseStatus(OK)
    public void changePriority(@PathVariable UUID id, @NotBlank @RequestBody String priority) {
        taskService.changePriority(id, priority);
    }
}