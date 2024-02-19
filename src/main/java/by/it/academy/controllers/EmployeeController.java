package by.it.academy.controllers;

import by.it.academy.dto.requests.CreateEmployeeRequest;
import by.it.academy.dto.responses.ReadEmployeeResponse;
import by.it.academy.services.employees.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("employee/{id}")
    @ResponseStatus(OK)
    public ReadEmployeeResponse getUser(@PathVariable UUID id) {
        return employeeService.getUserById(id);
    }

    @GetMapping("employees")
    @ResponseStatus(OK)
    public List<ReadEmployeeResponse> getAllUsers() {
        return employeeService.readEmployee();
    }

    @GetMapping("employees/team/{team_id}")
    @ResponseStatus(OK)
    public List<ReadEmployeeResponse> getEmployeesByTeamId(@PathVariable UUID team_id) {
        return employeeService.findAllEmployeesByTeamId(team_id);
    }

    @PostMapping("employee")
    @ResponseStatus(CREATED)
    public ReadEmployeeResponse createUser(@Valid @RequestBody CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @PutMapping("employee/{id}")
    @ResponseStatus(OK)
    public ReadEmployeeResponse updateEmployee(@PathVariable UUID id, @Valid @RequestBody CreateEmployeeRequest request) {
        return employeeService.updateEmployee(id, request);
    }

    @DeleteMapping("employee/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
    }
}