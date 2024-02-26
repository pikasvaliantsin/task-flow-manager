package by.it.academy.taskFlowManager;

import by.it.academy.repositories.employees.EmployeeRepository;
import by.it.academy.services.employees.EmployeeServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private final UUID uuid = UUID.fromString("0176349f-b3ac-4e68-bf16-7307ffa27ac1");

    @Test
    public void testGetEmployeeByIdWhenEmployeeNoExist() {
        when(employeeRepository.findById(uuid)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> employeeService.getEmployeeById(uuid));
    }
}