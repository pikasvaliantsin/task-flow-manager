package by.it.academy.dto.requests;

import by.it.academy.dto.TeamShortDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateEmployeeRequest {

    @NotBlank(message = "Firstname cannot be empty")
    @Size(max = 255, message = "Firstname cannot be more than 255 symbols")
    private String firstname;

    @NotBlank
    @Size(max = 255, message = "Second name cannot be more than 255 symbols")
    private String secondName;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    private List<TeamShortDto> teams;
}