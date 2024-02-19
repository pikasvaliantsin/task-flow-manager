package by.it.academy.dto.requests;

import by.it.academy.dto.TeamShortDto;
import by.it.academy.enums.Priority;
import by.it.academy.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class CreateTaskRequest {
    @NotBlank(message = "Title cannot be empty")
    @Size(max = 255, message = "Title cannot be more than 255 symbols")
    private String title;
    @NotBlank(message = "Title cannot be empty")
    @Size(max = 255, message = "Title cannot be more than 255 symbols")
    private String description;
    @NotNull(message = "Priority cannot be null")
    private Priority priority;
    @NotNull(message = "Status cannot be null")
    private Status status;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createTaskTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTaskTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime finishTaskTime;
    private TeamShortDto team;
}