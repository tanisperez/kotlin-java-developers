package codes.tanis.demojug.project.infrastructure.jpa

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "project")
data class ProjectEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "description", nullable = false)
    val description: String,

    @Column(name = "budget", nullable = false)
    val budget: Double,

    @Column(name = "start_date", nullable = false)
    val startDate: OffsetDateTime,

    @Column(name = "end_date")
    val endDate: OffsetDateTime?,

    @Column(name = "created_at", nullable = false)
    val createdAt: OffsetDateTime,

    @Column(name = "updated_at", nullable = false)
    val updatedAt: OffsetDateTime
) {
    // Constructor vacío para JPA
    constructor() : this(null, "", "", 0.0, OffsetDateTime.now(), null, OffsetDateTime.now(), OffsetDateTime.now())
}
