package by.it.academy.repositories.employees;

import by.it.academy.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>, EmployeeRepositoryCustom {
}