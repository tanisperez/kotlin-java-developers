package codes.tanis.demojug.employee.infrastructure.jpa;

import codes.tanis.demojug.common.Amount;
import codes.tanis.demojug.common.Currency;
import codes.tanis.demojug.common.Money;
import codes.tanis.demojug.employee.domain.Employee;
import codes.tanis.demojug.employee.domain.EmployeeID;
import codes.tanis.demojug.employee.domain.EmployeeRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeJpaRepository jpaRepository;

    public EmployeeRepositoryImpl(EmployeeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity entity = toDomain(employee);
        EmployeeEntity savedEntity = jpaRepository.save(entity);
        return toEntity(savedEntity);
    }

    @Override
    public Optional<Employee> findById(EmployeeID id) {
        return jpaRepository.findById(id.id())
                .map(this::toEntity);
    }

    @Override
    public List<Employee> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(this::toEntity)
                .toList();
    }

    @Override
    public void deleteById(EmployeeID id) {
        jpaRepository.deleteById(id.id());
    }

    @Override
    public boolean existsById(EmployeeID id) {
        return jpaRepository.existsById(id.id());
    }

    /**
     * Convierte una entidad JPA a un Employee del dominio
     */
    private Employee toEntity(EmployeeEntity entity) {
        Money salary = Money.of(
            Amount.of(entity.getSalary()),
            Currency.from(entity.getCurrency())
        );
        return new Employee(
            new EmployeeID(entity.getId()),
            entity.getName(),
            salary,
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    /**
     * Convierte un Employee del dominio a una entidad JPA
     */
    private EmployeeEntity toDomain(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();
        if (employee.id() != null && employee.id().id() > 0) {
            entity.setId(employee.id().id());
        }
        entity.setName(employee.name());
        entity.setSalary(employee.salary().amount().amount());
        entity.setCurrency(employee.salary().currency().code());
        entity.setCreatedAt(employee.createdAt());
        entity.setUpdatedAt(employee.updatedAt());
        return entity;
    }
}

