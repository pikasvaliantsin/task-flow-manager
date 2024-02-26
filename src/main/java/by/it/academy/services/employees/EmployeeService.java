package by.it.academy.services.employees;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    List<ReadEmployeeDto> getEmployees();

    ReadEmployeeDto createEmployee(CreateEmployeeRequest request);

    ReadEmployeeDto updateEmployee(UUID id, CreateEmployeeRequest request);

    void deleteEmployee(UUID id);

    ReadEmployeeDto getEmployeeById(UUID id);

    public List<ReadEmployeeDto> getAllEmployeesByTeamId(UUID teamId);
}