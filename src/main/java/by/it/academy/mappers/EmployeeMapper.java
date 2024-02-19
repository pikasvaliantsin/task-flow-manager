package by.it.academy.mappers;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeResponse;
import by.it.academy.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    ReadEmployeeResponse mapToEmployeeDTO(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee mapToEmployee(CreateEmployeeRequest request);

    List<ReadEmployeeResponse> mapEntityListToDtoList(List<Employee> employeeList);

    @Mapping(target = "id", ignore = true)
    ReadEmployeeResponse convertRequestToResponse(CreateEmployeeRequest request);

    CreateEmployeeRequest convertResponseToRequest(ReadEmployeeResponse response);
}