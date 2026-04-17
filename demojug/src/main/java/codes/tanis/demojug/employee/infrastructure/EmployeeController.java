package codes.tanis.demojug.employee.infrastructure;

import codes.tanis.demojug.employee.application.CreateEmployeeRequest;
import codes.tanis.demojug.employee.application.EmployeeService;
import codes.tanis.demojug.employee.application.EmployeeResponse;
import codes.tanis.demojug.employee.application.UpdateEmployeeRequest;
import codes.tanis.demojug.employee.domain.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees() {
        List<EmployeeResponse> employees = employeeService.getAllEmployees()
                .stream()
                .map(this::toResponse)
                .toList();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id)
                .map(employee -> ResponseEntity.ok(toResponse(employee)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody CreateEmployeeRequest request) {
        Employee savedEmployee = employeeService.createEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(savedEmployee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable Long id,
            @RequestBody UpdateEmployeeRequest request) {

        return employeeService.updateEmployee(id, request)
                .map(employee -> ResponseEntity.ok(toResponse(employee)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    private EmployeeResponse toResponse(Employee employee) {
        return new EmployeeResponse(
            employee.id().id(),
            employee.name(),
            employee.salary().amount().amount(),
            employee.salary().currency().code(),
            employee.createdAt(),
            employee.updatedAt()
        );
    }
}

