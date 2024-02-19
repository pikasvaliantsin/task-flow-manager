package by.it.academy.services.tasks;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskResponse;
import by.it.academy.entities.Task;
import by.it.academy.mappers.TaskMapper;
import by.it.academy.repositories.tasks.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ReadTaskResponse> readTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskMapper.mapEntityListToDtoList(taskList);
    }

    @Transactional
    @Override
    public ReadTaskResponse createTask(CreateTaskRequest request) {
        Task task = taskMapper.mapToTaskEntity(request);
        Task savedTask = taskRepository.save(task);
        return taskMapper.mapToTaskDTO(savedTask);
    }

    @Transactional
    @Override
    public ReadTaskResponse updateTask(UUID id, CreateTaskRequest request) {
        Task taskForUpdate = taskMapper.mapToTaskEntity(request);
        taskForUpdate.setId(id);
        taskRepository.save(taskForUpdate);
        return getTaskById(id);
    }

    @Transactional
    @Override
    public void deleteTask(UUID id) {
        if (taskRepository.deleteTaskById(id) == 0) {
            throw new EntityNotFoundException(id.toString());
        }
    }

    @Transactional
    @Override
    public boolean changeStatus(UUID id, String status) {
        if (taskRepository.changeStatus(id, status) == 0) {
            throw new EntityNotFoundException(id.toString());
        }
        return true;
    }

    @Transactional
    @Override
    public boolean changePriority(UUID id, String priority) {
        if(taskRepository.changePriority(id,priority)==0){
            throw new EntityNotFoundException(id.toString());
        }
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public ReadTaskResponse getTaskById(UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return taskMapper.mapToTaskDTO(task);
    }
}