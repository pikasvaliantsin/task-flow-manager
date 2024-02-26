package by.it.academy.repositories.tasks;

import by.it.academy.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID>, TaskRepositoryCustom {

    void deleteTaskById(UUID id);

    Optional<Task> findTaskByPersonalNumber(Integer number);
}