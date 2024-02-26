package by.it.academy.controllers;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeDto;
import by.it.academy.services.employees.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("employee/{id}")
    public ReadEmployeeDto getUser(@PathVariable UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("employees")
    public List<ReadEmployeeDto> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("employees/team/{teamId}")
    public List<ReadEmployeeDto> getEmployeesByTeamId(@PathVariable UUID teamId) {
        return employeeService.getAllEmployeesByTeamId(teamId);
    }

    @PostMapping("employee")
    @ResponseStatus(CREATED)
    public ReadEmployeeDto createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @PutMapping("employee/{id}")
    public ReadEmployeeDto updateEmployee(@PathVariable UUID id, @Valid @RequestBody CreateEmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("employee/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
    }
}