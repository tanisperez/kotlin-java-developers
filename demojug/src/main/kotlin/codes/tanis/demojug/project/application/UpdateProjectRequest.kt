package codes.tanis.demojug.project.application

import java.time.OffsetDateTime

data class UpdateProjectRequest(
    val name: String,
    val description: String,
    val budget: Double,
    val startDate: OffsetDateTime,
    val endDate: OffsetDateTime?
)
