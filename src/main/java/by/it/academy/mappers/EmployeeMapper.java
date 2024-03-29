package by.it.academy.mappers;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeDto;
import by.it.academy.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    ReadEmployeeDto mapToDto(Employee employee);

    @Mapping(target = "id", ignore = true)
    Employee mapToEmployee(CreateEmployeeRequest request);

    List<ReadEmployeeDto> mapEmployeesToDtos(List<Employee> employeeList);

    @Mapping(target = "id", ignore = true)
    ReadEmployeeDto convertRequestToResponse(CreateEmployeeRequest request);
}