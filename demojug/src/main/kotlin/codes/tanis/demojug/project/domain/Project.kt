package codes.tanis.demojug.project.domain

import codes.tanis.demojug.employee.domain.EmployeeID
import java.time.OffsetDateTime

data class Project(
    val id: ProjectID,
    val name: String,
    val description: String,
    val budget: Double,
    val startDate: OffsetDateTime,
    val endDate: OffsetDateTime?,
    val employeeIds: Set<EmployeeID>,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime
)
