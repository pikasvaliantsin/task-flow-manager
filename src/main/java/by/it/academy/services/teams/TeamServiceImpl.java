package by.it.academy.services.teams;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamDto;
import by.it.academy.entities.Team;
import by.it.academy.mappers.TeamMapper;
import by.it.academy.repositories.teams.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ReadTeamDto> getTeams() {
        List<Team> teamList = teamRepository.findAll();
        return teamMapper.mapTeamsToDtos(teamList);
    }

    @Transactional
    @Override
    public ReadTeamDto createTeam(CreateTeamRequest request) {
        Team team = teamMapper.mapToTeam(request);
        Team teamForSave = teamRepository.save(team);
        return teamMapper.mapToDto(teamForSave);
    }

    @Transactional
    @Override
    public ReadTeamDto updateTeam(UUID id, CreateTeamRequest request) {
        Team teamForUpdate = teamMapper.mapToTeam(request);
        teamForUpdate.setId(id);
        Team updatedTeam = teamRepository.save(teamForUpdate);
        return teamMapper.mapToDto(updatedTeam);
    }

    @Transactional
    @Override
    public void deleteTeam(UUID id) {
        teamRepository.deleteTeamById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public ReadTeamDto getTeamById(UUID id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return teamMapper.mapToDto(team);
    }
}