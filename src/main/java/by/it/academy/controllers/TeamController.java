package by.it.academy.controllers;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamDto;
import by.it.academy.services.teams.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TeamController {

    private final TeamService teamService;

    @GetMapping("team/{id}")
    public ReadTeamDto getTeam(@PathVariable UUID id) {
        return teamService.getTeamById(id);
    }

    @GetMapping("teams")
    public List<ReadTeamDto> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping("team")
    @ResponseStatus(CREATED)
    public ReadTeamDto createTeam(@Valid @RequestBody CreateTeamRequest request) {
        return teamService.createTeam(request);
    }

    @PutMapping("team/{id}")
    public ReadTeamDto updateTeam(@PathVariable UUID id, @Valid @RequestBody CreateTeamRequest request) {
        return teamService.updateTeam(id, request);
    }

    @DeleteMapping("team/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteTeam(@PathVariable UUID id) {
        teamService.deleteTeam(id);
    }
}