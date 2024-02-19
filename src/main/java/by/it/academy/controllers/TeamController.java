package by.it.academy.controllers;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamResponse;
import by.it.academy.mappers.TeamMapper;
import by.it.academy.services.teams.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TeamController {
    private final TeamService teamService;

    @GetMapping("team/{id}")
    @ResponseStatus(OK)
    public ReadTeamResponse getTeam(@PathVariable UUID id) {
        return teamService.getTeamById(id);
    }

    @GetMapping("teams")
    @ResponseStatus(OK)
    public List<ReadTeamResponse> getAllTeams() {
        return teamService.readTeams();
    }

    @PostMapping("team")
    @ResponseStatus(CREATED)
    public ReadTeamResponse createTeam(@Valid @RequestBody CreateTeamRequest request) {
        return teamService.createTeam(request);
    }

    @PutMapping("team/{id}")
    @ResponseStatus(OK)
    public ReadTeamResponse updateTeam(@PathVariable UUID id, @Valid @RequestBody CreateTeamRequest request) {
        return  teamService.updateTeam(id, request);
    }
    @DeleteMapping("team/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTeam(@PathVariable UUID id) {
        teamService.deleteTeam(id);
    }
}