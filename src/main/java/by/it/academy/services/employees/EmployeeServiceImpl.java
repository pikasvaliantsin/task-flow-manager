package by.it.academy.services.employees;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeDto;
import by.it.academy.entities.Employee;
import by.it.academy.mappers.EmployeeMapper;
import by.it.academy.repositories.employees.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Transactional(readOnly = true)
    @Override
    public List<ReadEmployeeDto> getEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.mapEmployeesToDtos(employeeList);
    }

    @Transactional
    @Override
    public ReadEmployeeDto createEmployee(CreateEmployeeRequest request) {
        Employee employee = employeeMapper.mapToEmployee(request);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToDto(savedEmployee);
    }

    @Transactional
    @Override
    public ReadEmployeeDto updateEmployee(UUID id, CreateEmployeeRequest request) {
        Employee employeeForUpdate = employeeMapper.mapToEmployee(request);
        employeeForUpdate.setId(id);
        Employee updatedEmployee = employeeRepository.save(employeeForUpdate);
        return employeeMapper.mapToDto(updatedEmployee);
    }

    @Transactional
    @Override
    public void deleteEmployee(UUID id) {
        employeeRepository.deleteEmployeeById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public ReadEmployeeDto getEmployeeById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return employeeMapper.mapToDto(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadEmployeeDto> getAllEmployeesByTeamId(UUID teamId) {
        return employeeMapper.mapEmployeesToDtos(employeeRepository.findAllEmployeesByTeamId(teamId));
    }
}