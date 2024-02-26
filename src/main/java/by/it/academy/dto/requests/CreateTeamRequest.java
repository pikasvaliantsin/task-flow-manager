package by.it.academy.dto.requests;

import by.it.academy.dto.EmployeeShortDto;
import by.it.academy.dto.TaskShortDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeamRequest {

    @NotBlank(message = "Name cannot be empty")
    @Size(max = 255, message = "Name cannot be more than 255 symbols")
    private String name;

    private List<EmployeeShortDto> employees;

    private List<TaskShortDto> tasks;
}