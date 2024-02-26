package by.it.academy.mappers;

import by.it.academy.dto.requests.CreateTaskRequest;
import by.it.academy.dto.responses.ReadTaskDto;
import by.it.academy.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = TeamMapper.class)
public interface TaskMapper {

    String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";

    @Mappings({
            @Mapping(target = "startTaskTime", dateFormat = DATE_FORMAT_PATTERN),
            @Mapping(target = "createTaskTime", dateFormat = DATE_FORMAT_PATTERN),
            @Mapping(target = "finishTaskTime", dateFormat = DATE_FORMAT_PATTERN)
    })
    ReadTaskDto mapToDto(Task task);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "personalNumber", ignore = true),
            @Mapping(target = "startTaskTime", dateFormat = DATE_FORMAT_PATTERN),
            @Mapping(target = "createTaskTime", dateFormat = DATE_FORMAT_PATTERN),
            @Mapping(target = "finishTaskTime", dateFormat = DATE_FORMAT_PATTERN)
    })
    Task mapToTask(CreateTaskRequest request);

    List<ReadTaskDto> mapTasksToDtos(List<Task> tasks);
}