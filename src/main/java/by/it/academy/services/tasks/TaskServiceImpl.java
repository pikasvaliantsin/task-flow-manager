package by.it.academy.services.tasks;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.PersonalNumberDto;
import by.it.academy.dto.responses.ReadTaskDto;
import by.it.academy.entities.Task;
import by.it.academy.feingClient.PersonalNumberApiClient;
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

    private final PersonalNumberApiClient personalNumberApiClient;

    final int COUNT_CHANGED_ROWS = 0;

    @Transactional(readOnly = true)
    @Override
    public List<ReadTaskDto> getTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskMapper.mapTasksToDtos(taskList);
    }

    @Transactional
    @Override
    public ReadTaskDto createTask(CreateTaskRequest request) {
        Task task = taskMapper.mapToTask(request);
        PersonalNumberDto personalNumberDto = personalNumberApiClient.getPersonalNumber();
        task.setPersonalNumber(personalNumberDto.getPersonalNumber());
        Task savedTask = taskRepository.save(task);
        return taskMapper.mapToDto(savedTask);
    }

    @Transactional
    @Override
    public ReadTaskDto updateTask(UUID id, CreateTaskRequest request) {
        Task taskForUpdate = taskMapper.mapToTask(request);
        taskForUpdate.setId(id);
        taskRepository.save(taskForUpdate);
        return getTaskById(id);
    }

    @Transactional
    @Override
    public void deleteTask(UUID id) {
        taskRepository.deleteTaskById(id);
    }

    @Transactional
    @Override
    public boolean changePriority(UUID id, String priority) {
        if (taskRepository.changePriority(id, priority) == COUNT_CHANGED_ROWS) {
            throw new EntityNotFoundException(id.toString());
        }
        return true;
    }

    @Transactional(readOnly = true)
    @Override
    public ReadTaskDto getTaskById(UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return taskMapper.mapToDto(task);
    }

    @Override
    public ReadTaskDto getTaskByPersonalNumber(Integer number) {
        Task task = taskRepository.findTaskByPersonalNumber(number)
                .orElseThrow(() -> new EntityNotFoundException(number.toString()));
        return taskMapper.mapToDto(task);
    }
}