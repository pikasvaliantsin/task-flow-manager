package by.it.academy.services.employees;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<ReadEmployeeResponse> readEmployee();

    ReadEmployeeResponse createEmployee(CreateEmployeeRequest request);

    ReadEmployeeResponse updateEmployee(UUID id, CreateEmployeeRequest request);

    void deleteEmployee(UUID id);

    ReadEmployeeResponse getUserById(UUID id);

    public List<ReadEmployeeResponse> findAllEmployeesByTeamId(UUID team_id);
}
