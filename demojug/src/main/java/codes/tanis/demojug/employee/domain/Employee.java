package codes.tanis.demojug.employee.domain;

import codes.tanis.demojug.common.Money;

import java.time.OffsetDateTime;

public record Employee(
    EmployeeID id,
    String name,
    Money salary,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt
) {
}
