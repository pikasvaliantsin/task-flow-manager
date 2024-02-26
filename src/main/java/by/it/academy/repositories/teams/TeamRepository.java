package by.it.academy.repositories.teams;

import by.it.academy.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    void deleteTeamById(UUID id);
}