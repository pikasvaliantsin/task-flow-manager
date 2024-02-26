package by.it.academy.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeShortDto {

    private UUID id;
    private String firstName;
    private String secondName;
    private String email;
}
