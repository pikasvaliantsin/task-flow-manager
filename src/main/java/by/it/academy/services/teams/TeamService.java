package by.it.academy.services.teams;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamResponse;

import java.util.List;
import java.util.UUID;

public interface TeamService {
    List<ReadTeamResponse> readTeams();

    ReadTeamResponse createTeam(CreateTeamRequest request);

    ReadTeamResponse updateTeam(UUID id, CreateTeamRequest request);

    void deleteTeam(UUID id);

    ReadTeamResponse getTeamById(UUID id);
}