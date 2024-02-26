package by.it.academy.services.teams;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamDto;

import java.util.List;
import java.util.UUID;

public interface TeamService {

    List<ReadTeamDto> getTeams();

    ReadTeamDto createTeam(CreateTeamRequest request);

    ReadTeamDto updateTeam(UUID id, CreateTeamRequest request);

    void deleteTeam(UUID id);

    ReadTeamDto getTeamById(UUID id);
}