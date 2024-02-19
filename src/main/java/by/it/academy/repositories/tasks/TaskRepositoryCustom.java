package by.it.academy.repositories.tasks;

import java.util.UUID;

public interface TaskRepositoryCustom {
    long changeStatus(UUID id, String status);

    long changePriority(UUID id, String priority);

    long deleteTaskById(UUID id);
}