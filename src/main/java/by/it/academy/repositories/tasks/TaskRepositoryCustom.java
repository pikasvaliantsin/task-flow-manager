package by.it.academy.repositories.tasks;

import java.util.UUID;

public interface TaskRepositoryCustom {
    long changePriority(UUID id, String priority);
}