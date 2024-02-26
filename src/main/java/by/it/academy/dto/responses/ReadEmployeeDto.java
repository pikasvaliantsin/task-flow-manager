package by.it.academy.dto.responses;

import by.it.academy.dto.TeamShortDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReadEmployeeDto {

    private UUID id;
    private String firstname;
    private String secondName;
    private String email;
    private List<TeamShortDto> teams;
}