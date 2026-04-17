package codes.tanis.demojug.employee.application;

import codes.tanis.demojug.common.Amount;
import codes.tanis.demojug.common.Currency;
import codes.tanis.demojug.common.Money;
import codes.tanis.demojug.employee.domain.Employee;
import codes.tanis.demojug.employee.domain.EmployeeID;
import codes.tanis.demojug.employee.domain.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(new EmployeeID(id));
    }

    public Employee createEmployee(CreateEmployeeRequest request) {
        Money salary = Money.of(
            Amount.of(request.salary()),
            Currency.from(request.currency())
        );

        Employee newEmployee = new Employee(
            null,
            request.name(),
            salary,
            OffsetDateTime.now(),
            OffsetDateTime.now()
        );

        return employeeRepository.save(newEmployee);
    }

    public Optional<Employee> updateEmployee(Long id, UpdateEmployeeRequest request) {
        EmployeeID employeeId = new EmployeeID(id);

        return employeeRepository.findById(employeeId)
                .map(existingEmployee -> {
                    Money salary = Money.of(
                            Amount.of(request.salary()),
                            Currency.from(request.currency())
                    );

                    Employee updatedEmployee = new Employee(
                            employeeId,
                            request.name(),
                            salary,
                            existingEmployee.createdAt(),
                            OffsetDateTime.now()
                    );

                    return employeeRepository.save(updatedEmployee);
                });
    }

    public boolean deleteEmployee(Long id) {
        EmployeeID employeeId = new EmployeeID(id);

        if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId);
            return true;
        }

        return false;
    }
}

