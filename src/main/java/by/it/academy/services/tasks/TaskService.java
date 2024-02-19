package by.it.academy.services.tasks;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<ReadTaskResponse> readTasks();

    ReadTaskResponse createTask(CreateTaskRequest request);

    ReadTaskResponse updateTask(UUID id, CreateTaskRequest request);

    void deleteTask(UUID id);

    boolean changeStatus(UUID id, String status);

    boolean changePriority(UUID id, String priority);

    ReadTaskResponse getTaskById(UUID id);
}