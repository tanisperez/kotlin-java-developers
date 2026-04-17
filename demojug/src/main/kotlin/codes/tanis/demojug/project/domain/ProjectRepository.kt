package codes.tanis.demojug.project.domain

interface ProjectRepository {

    fun save(project: Project): Project

    fun findById(id: ProjectID): Project?

    fun findAll(): List<Project>

    fun deleteById(id: ProjectID)

    fun existsById(id: ProjectID): Boolean

}
