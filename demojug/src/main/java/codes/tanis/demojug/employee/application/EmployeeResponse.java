package codes.tanis.demojug.employee.application;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record EmployeeResponse(
    Long id,
    String name,
    BigDecimal salary,
    String currency,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {
}

