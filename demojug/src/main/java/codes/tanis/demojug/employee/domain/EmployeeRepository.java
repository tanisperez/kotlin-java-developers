package codes.tanis.demojug.employee.domain;

import java.util.Optional;
import java.util.List;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Optional<Employee> findById(EmployeeID id);

    List<Employee> findAll();

    void deleteById(EmployeeID id);

    boolean existsById(EmployeeID id);

}

