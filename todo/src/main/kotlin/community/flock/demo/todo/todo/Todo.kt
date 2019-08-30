package community.flock.demo.todo.todo

import community.flock.demo.todo.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.time.ZoneOffset

@Table("todos")
class Todo(

        @Id val id: Long,

        val description: String,
        val due: Long

) : Exposable<ExposedTodo> {

    override fun expose(): ExposedTodo = ExposedTodo(
            description = description,
            due = LocalDateTime.ofEpochSecond(due, 0, ZoneOffset.UTC)
    )

}

class ExposedTodo(
        val description: String,
        val due: LocalDateTime
)
