package codes.tanis.demojug.project.infrastructure

import codes.tanis.demojug.project.application.CreateProjectRequest
import codes.tanis.demojug.project.application.ProjectResponse
import codes.tanis.demojug.project.application.ProjectService
import codes.tanis.demojug.project.application.UpdateProjectRequest
import codes.tanis.demojug.project.domain.Project
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/projects")
class ProjectController(
    private val projectService: ProjectService
) {

    @GetMapping
    fun getAllProjects(): ResponseEntity<List<ProjectResponse>> {
        val projects = projectService.getAllProjects()
            .map { toResponse(it) }
        return ResponseEntity.ok(projects)
    }

    @GetMapping("/{id}")
    fun getProjectById(@PathVariable id: Long): ResponseEntity<ProjectResponse> {
        val project = projectService.getProjectById(id)
        return if (project != null) {
            ResponseEntity.ok(toResponse(project))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun createProject(@RequestBody request: CreateProjectRequest): ResponseEntity<ProjectResponse> {
        val savedProject = projectService.createProject(request)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(toResponse(savedProject))
    }

    @PutMapping("/{id}")
    fun updateProject(
        @PathVariable id: Long,
        @RequestBody request: UpdateProjectRequest
    ): ResponseEntity<ProjectResponse> {
        val updatedProject = projectService.updateProject(id, request)
        return if (updatedProject != null) {
            ResponseEntity.ok(toResponse(updatedProject))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteProject(@PathVariable id: Long): ResponseEntity<Void> {
        val deleted = projectService.deleteProject(id)
        return if (deleted) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    private fun toResponse(project: Project): ProjectResponse {
        return ProjectResponse(
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
