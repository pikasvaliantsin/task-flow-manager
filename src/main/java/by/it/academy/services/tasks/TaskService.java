package by.it.academy.services.tasks;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    List<ReadTaskDto> getTasks();

    ReadTaskDto createTask(CreateTaskRequest request);

    ReadTaskDto updateTask(UUID id, CreateTaskRequest request);

    void deleteTask(UUID id);

    boolean changePriority(UUID id, String priority);

    ReadTaskDto getTaskById(UUID id);

    ReadTaskDto getTaskByPersonalNumber(Integer number);
}