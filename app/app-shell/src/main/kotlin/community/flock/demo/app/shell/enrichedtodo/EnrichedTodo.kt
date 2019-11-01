package community.flock.demo.app.shell.enrichedtodo

import community.flock.demo.app.common.usefull.Exposable
import community.flock.demo.app.shell.todo.Todo
import community.flock.demo.app.user.User
import java.time.LocalDate
import java.time.Period
import community.flock.demo.app.common.generated.User as ExposedUser

data class EnrichedTodo(
        private val description: String,
        private val due: LocalDate,
        private val user: User
) : Exposable<ExposedEnrichedTodo> {

    constructor(todo: Todo, user: User) : this(
            description = todo.description,
            due = LocalDate.parse(todo.due),
            user = user
    )

    override fun expose(): ExposedEnrichedTodo = ExposedEnrichedTodo(
            description = description,
            due = due.toString(),
            ageWhenDue = Period.between(user.birthday, due).years,
            responsibleUser = user.expose().copy(favouriteColour = null)
    )

}

internal fun Todo.compose(user: User) = EnrichedTodo(this, user)

class ExposedEnrichedTodo(
        val description: String,
        val due: String,
        val ageWhenDue: Int,
        val responsibleUser: ExposedUser
)
