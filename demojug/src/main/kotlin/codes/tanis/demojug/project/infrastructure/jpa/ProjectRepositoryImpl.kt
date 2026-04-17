package codes.tanis.demojug.project.infrastructure.jpa

import codes.tanis.demojug.employee.domain.EmployeeID
import codes.tanis.demojug.project.domain.Project
import codes.tanis.demojug.project.domain.ProjectID
import codes.tanis.demojug.project.domain.ProjectRepository
import org.springframework.stereotype.Component
import kotlin.collections.emptySet

@Component
class ProjectRepositoryImpl(
    private val jpaRepository: ProjectJpaRepository
) : ProjectRepository {

    override fun save(project: Project): Project {
        val entity = toEntity(project)
        val savedEntity = jpaRepository.save(entity)
        return toDomain(savedEntity)
    }

    override fun findById(id: ProjectID): Project? {
        return jpaRepository.findById(id.id)
            .map { toDomain(it) }
            .orElse(null)
    }

    override fun findAll(): List<Project> {
        return jpaRepository.findAll()
            .map { toDomain(it) }
    }

    override fun deleteById(id: ProjectID) {
        jpaRepository.deleteById(id.id)
    }

    override fun existsById(id: ProjectID): Boolean {
        return jpaRepository.existsById(id.id)
    }

    private fun toDomain(entity: ProjectEntity): Project {
        return Project(
            id = ProjectID(entity.id!!),
            name = entity.name,
            description = entity.description,
            budget = entity.budget,
            startDate = entity.startDate,
            endDate = entity.endDate,
            employeeIds = emptySet(),
            createdAt = entity.createdAt,
            updatedAt = entity.updatedAt
        )
    }

    private fun toEntity(project: Project): ProjectEntity {
        return ProjectEntity(
            id = project.id.id,
            name = project.name,
            description = project.description,
            budget = project.budget,
            startDate = project.startDate,
            endDate = project.endDate,
            createdAt = project.createdAt,
            updatedAt = project.updatedAt
        )
    }
}
