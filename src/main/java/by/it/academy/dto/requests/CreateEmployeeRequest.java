package by.it.academy.dto.requests;

import by.it.academy.dto.TeamShortDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Validated
public class CreateEmployeeRequest {
    @NotBlank(message = "Firstname cannot be empty")
    @Size(max = 255, message = "Firstname cannot be more than 255 symbols")
    private String firstName;
    @NotBlank
    private String secondName;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;
    private List<TeamShortDto> teams;
}
