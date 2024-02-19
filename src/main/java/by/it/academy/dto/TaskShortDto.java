package by.it.academy.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TaskShortDto {
    private UUID id;
    private String title;
    private String description;
}