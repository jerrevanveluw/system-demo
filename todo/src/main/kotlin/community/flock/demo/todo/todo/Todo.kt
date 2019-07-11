package community.flock.demo.todo.todo

import community.flock.demo.todo.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Table("todos")
class Todo(

        @Id val id: Long,

        val description: String,
        val due: Long

) : Exposable<Todo.Exposed> {

    override fun expose(): Exposed = Exposed(
            description = description,
            due = LocalDateTime.ofEpochSecond(due, 0, ZoneOffset.UTC)
    )

    class Exposed(
            val description: String,
            val due: LocalDateTime
    )

}
