package by.it.academy.mappers;

import by.it.academy.dto.requests.CreateTeamRequest;
import by.it.academy.dto.responses.ReadTeamResponse;
import by.it.academy.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = EmployeeMapper.class)
public interface TeamMapper {
    ReadTeamResponse mapToTeamDTO(Team team);

    @Mapping(target = "id", ignore = true)
    Team mapToTeamEntity(CreateTeamRequest request);

    List<ReadTeamResponse> mapEntityListToDtoList (List<Team> teams);
}