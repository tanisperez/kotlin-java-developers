package codes.tanis.demojug.project.infrastructure.jpa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface ProjectJpaRepository : JpaRepository<ProjectEntity, Long>
