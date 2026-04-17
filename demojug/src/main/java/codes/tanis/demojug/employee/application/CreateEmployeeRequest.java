package codes.tanis.demojug.employee.application;

import java.math.BigDecimal;

public record CreateEmployeeRequest(
    String name,
    BigDecimal salary,
    String currency
) {
}

