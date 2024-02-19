package by.it.academy.services.teams;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamResponse;
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
    public List<ReadTeamResponse> readTeams() {
        List<Team> teamList = teamRepository.findAll();
        return teamMapper.mapEntityListToDtoList(teamList);
    }

    @Transactional
    @Override
    public ReadTeamResponse createTeam(CreateTeamRequest request) {
        Team team = teamMapper.mapToTeamEntity(request);
        Team teamForSave = teamRepository.save(team);
        return teamMapper.mapToTeamDTO(teamForSave);
    }

    @Transactional
    @Override
    public ReadTeamResponse updateTeam(UUID id, CreateTeamRequest request) {
        Team teamForUpdate = teamMapper.mapToTeamEntity(request);
        teamForUpdate.setId(id);
        Team updatedTeam = teamRepository.save(teamForUpdate);
        return teamMapper.mapToTeamDTO(updatedTeam);
    }

    @Transactional
    @Override
    public void deleteTeam(UUID id) {
        if (teamRepository.deleteTeamById(id)==0) {
            throw new EntityNotFoundException(id.toString());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ReadTeamResponse getTeamById(UUID id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return teamMapper.mapToTeamDTO(team);
    }
}
