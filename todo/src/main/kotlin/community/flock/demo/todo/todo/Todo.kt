package community.flock.demo.todo.todo

import community.flock.demo.todo.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate

@Table("todos")
class Todo(

        @Id val id: Long? = null,

        private val description: String,
        private val due: LocalDate,
        private val userName: String?

) : Exposable<ExposedTodo> {

    constructor(todo: PotentialTodo) : this(
            description = todo.description,
            due = LocalDate.parse(todo.due),
            userName = todo.userName
    )

    constructor(todo: Map<String, Any>) : this(
            id = todo["id"] as Long,
            description = todo["description"] as String,
            due = todo["due"] as LocalDate,
            userName = todo["user_name"] as String?
    )

    override fun expose(): ExposedTodo = ExposedTodo(
            description = description,
            due = due.toString(),
            userName = userName
    )

}

internal fun Map<String, Any>.internalize() = Todo(this)

data class PotentialTodo(
        val description: String,
        val due: String,
        val userName: String?
) {
    internal fun consume() = Todo(this)
}

data class ExposedTodo(
        val description: String,
        val due: String,
        val userName: String?
)
