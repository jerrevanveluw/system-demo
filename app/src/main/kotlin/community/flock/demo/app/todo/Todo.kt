package community.flock.demo.app.todo

import community.flock.demo.app.usefull.Exposable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Todo(
        private val description: String,
        private val due: LocalDateTime
) : Exposable<ExposedTodo> {

    override fun expose(): ExposedTodo = ExposedTodo(
            description = description,
            due = due.format(dateTimeFormat)
    )

    companion object {
        val dateTimeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy 'at' H:mm")
    }

}

class ExposedTodo(
        val description: String,
        val due: String
)
