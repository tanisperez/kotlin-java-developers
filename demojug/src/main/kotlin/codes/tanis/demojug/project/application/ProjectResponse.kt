package codes.tanis.demojug.project.application

import java.time.OffsetDateTime

data class ProjectResponse(
    val id: Long,
    val name: String,
    val description: String,
    val budget: Double,
    val startDate: OffsetDateTime,
    val endDate: OffsetDateTime?,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime
)
