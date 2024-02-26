package by.it.academy.mappers;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamDto;
import by.it.academy.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface TeamMapper {

    ReadTeamDto mapToDto(Team team);

    @Mapping(target = "id", ignore = true)
    Team mapToTeam(CreateTeamRequest request);

    List<ReadTeamDto> mapTeamsToDtos(List<Team> teams);
}