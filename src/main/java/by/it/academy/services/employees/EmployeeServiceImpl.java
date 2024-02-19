package by.it.academy.services.employees;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeResponse;
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
    public List<ReadEmployeeResponse> readEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.mapEntityListToDtoList(employeeList);
    }

    @Transactional
    @Override
    public ReadEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        Employee employee = employeeMapper.mapToEmployee(request);
        Employee savedEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeDTO(savedEmployee);
    }

    @Transactional
    @Override
    public ReadEmployeeResponse updateEmployee(UUID id, CreateEmployeeRequest request) {
        Employee employeeForUpdate = employeeMapper.mapToEmployee(request);
        employeeForUpdate.setId(id);
        Employee updatedEmployee = employeeRepository.save(employeeForUpdate);
        return employeeMapper.mapToEmployeeDTO(updatedEmployee);
    }

    @Transactional
    @Override
    public void deleteEmployee(UUID id) {
        if(employeeRepository.deleteEmployeeById(id)==0){
            throw new EntityNotFoundException(id.toString());
        }
    }

    @Transactional(readOnly = true)
    @Override
    public ReadEmployeeResponse getUserById(UUID id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
        return employeeMapper.mapToEmployeeDTO(employee);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ReadEmployeeResponse> findAllEmployeesByTeamId(UUID team_id) {
        return employeeMapper.mapEntityListToDtoList(employeeRepository.findAllEmployeesByTeamId(team_id));
    }
}