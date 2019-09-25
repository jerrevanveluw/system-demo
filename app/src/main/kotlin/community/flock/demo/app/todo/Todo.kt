package community.flock.demo.app.todo

import community.flock.demo.app.usefull.Exposable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Todo(
        val description: String,
        val due: String,
        val userName: String?
) : Exposable<ExposedTodo> {

    override fun expose(): ExposedTodo = ExposedTodo(
            description = description,
            due = due,
            name = userName
    )

    companion object {
        val dateTimeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy 'at' H:mm")
    }

}

class ExposedTodo(
        val description: String,
        val due: String,
        val name: String?
)
