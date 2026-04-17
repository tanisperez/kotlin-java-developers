package codes.tanis.demojug.project.application

import codes.tanis.demojug.project.domain.Project
import codes.tanis.demojug.project.domain.ProjectID
import codes.tanis.demojug.project.domain.ProjectRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class ProjectService(
    private val projectRepository: ProjectRepository
) {
    fun getAllProjects(): List<Project> {
        return projectRepository.findAll()
    }

    fun getProjectById(id: Long): Project? {
        return projectRepository.findById(ProjectID(id))
    }

    fun createProject(request: CreateProjectRequest): Project {
        val newProject = Project(
            id = ProjectID(0), // El ID será asignado por la base de datos
            name = request.name,
            description = request.description,
            budget = request.budget,
            startDate = request.startDate,
            endDate = request.endDate,
            employeeIds = emptySet(), // Por ahora vacío
            createdAt = OffsetDateTime.now(),
            updatedAt = OffsetDateTime.now()
        )
        return projectRepository.save(newProject)
    }

    fun updateProject(id: Long, request: UpdateProjectRequest): Project? {
        val projectId = ProjectID(id)
        return projectRepository.findById(projectId)?.let { existingProject ->
            val updatedProject = Project(
                id = projectId,
                name = request.name,
                description = request.description,
                budget = request.budget,
                startDate = request.startDate,
                endDate = request.endDate,
                employeeIds = existingProject.employeeIds,
                createdAt = existingProject.createdAt,
                updatedAt = OffsetDateTime.now()
            )
            projectRepository.save(updatedProject)
        }
    }

    fun deleteProject(id: Long): Boolean {
        val projectId = ProjectID(id)
        return if (projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId)
            true
        } else {
            false
        }
    }
}
