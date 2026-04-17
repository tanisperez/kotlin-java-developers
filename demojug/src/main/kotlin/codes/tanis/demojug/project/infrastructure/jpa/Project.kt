package codes.tanis.demojug.project.infrastructure.jpa

import codes.tanis.demojug.employee.domain.Employee
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany

@Entity
data class Project(
    @Id @GeneratedValue
    val id: Long? = null,

    val name: String,

    @ManyToMany(mappedBy = "projects")
    val employees: MutableSet<Employee> = mutableSetOf()
)
