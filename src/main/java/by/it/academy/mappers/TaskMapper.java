package by.it.academy.mappers;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskResponse;
import by.it.academy.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = TeamMapper.class)
public interface TaskMapper {
    @Mappings({
            @Mapping(target = "startTaskTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss"),
            @Mapping(target = "createTaskTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss"),
            @Mapping(target = "finishTaskTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    })
    ReadTaskResponse mapToTaskDTO(Task task);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "startTaskTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss"),
            @Mapping(target = "createTaskTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss"),
            @Mapping(target = "finishTaskTime", dateFormat = "yyyy-MM-dd'T'HH:mm:ss")
    })
    Task mapToTaskEntity(CreateTaskRequest request);

    List<ReadTaskResponse> mapEntityListToDtoList(List<Task> tasks);
}