package community.flock.demo.app.todo

import community.flock.demo.app.usefull.Exposable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Todo(
        private val description: String,
        private val due: LocalDateTime
) : Exposable<Todo.Exposed> {

    override fun expose(): Exposed = Exposed(
            description = description,
            due = due.format(dateTimeFormat)
    )

    class Exposed(
            val description: String,
            val due: String
    )

    companion object {
        val dateTimeFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy 'at' H:mm")
    }

}
