package by.it.academy.repositories.employees;

import by.it.academy.entities.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepositoryCustom {
    List<Employee> findAllEmployeesByTeamId(UUID team_id);

    long deleteEmployeeById(UUID id);

}
