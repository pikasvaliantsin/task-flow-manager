package by.it.academy.dto.responses;

import by.it.academy.dto.TaskShortDto;
import by.it.academy.dto.EmployeeShortDto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ReadTeamResponse {
    private UUID id;
    private String name;
    private List<EmployeeShortDto> employees;
    private List<TaskShortDto> tasks;
}