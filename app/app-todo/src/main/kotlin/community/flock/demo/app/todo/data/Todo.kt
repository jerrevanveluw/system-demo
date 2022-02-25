package community.flock.demo.app.todo.data

import community.flock.demo.app.common.usefull.Producible
import community.flock.demo.app.common.generated.Todo as ProducedTodo

data class Todo(
    val description: String,
    val due: String,
    val userName: String?
) : Producible<ProducedTodo> {

    override fun produce(): ProducedTodo = ProducedTodo(
        description = description,
        due = due,
        name = userName
    )

}
