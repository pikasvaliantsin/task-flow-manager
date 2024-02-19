package by.it.academy.dto.responses;

import by.it.academy.dto.TeamShortDto;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ReadEmployeeResponse {
    private UUID id;
    private String firstName;
    private String secondName;
    private String email;
    private List<TeamShortDto> teams;
}