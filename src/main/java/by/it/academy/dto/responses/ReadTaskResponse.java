package by.it.academy.dto.responses;

import by.it.academy.dto.TeamShortDto;
import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ReadTaskResponse {
    private UUID id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private String createTaskTime;
    private String startTaskTime;
    private String finishTaskTime;
    private TeamShortDto team;
}