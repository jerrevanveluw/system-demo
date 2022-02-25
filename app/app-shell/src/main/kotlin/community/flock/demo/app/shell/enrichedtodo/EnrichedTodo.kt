package community.flock.demo.app.shell.enrichedtodo

import community.flock.demo.app.common.usefull.Producible
import community.flock.demo.app.todo.data.Todo
import community.flock.demo.app.user.data.User
import java.time.LocalDate
import java.time.Period
import community.flock.demo.app.common.generated.User as ProducedUser

data class EnrichedTodo(
    private val description: String,
    private val due: LocalDate,
    private val user: User
) : Producible<ProducedEnrichedTodo> {

    constructor(todo: Todo, user: User) : this(
        description = todo.description,
        due = LocalDate.parse(todo.due),
        user = user
    )

    override fun produce(): ProducedEnrichedTodo = ProducedEnrichedTodo(
        description = description,
        due = due.toString(),
        ageWhenDue = Period.between(user.birthday, due).years,
        responsibleUser = user.produce().copy(favouriteColour = null)
    )

}

internal fun Todo.enrichWith(user: User) = EnrichedTodo(this, user)

class ProducedEnrichedTodo(
    val description: String,
    val due: String,
    val ageWhenDue: Int,
    val responsibleUser: ProducedUser
)
