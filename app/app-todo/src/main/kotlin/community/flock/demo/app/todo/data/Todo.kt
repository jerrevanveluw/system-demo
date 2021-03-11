package community.flock.demo.app.todo.data

import community.flock.demo.app.common.usefull.Exposable
import community.flock.demo.app.common.generated.Todo as ExposedTodo

data class Todo(
    val description: String,
    val due: String,
    val userName: String?
) : Exposable<ExposedTodo> {

    override fun expose(): ExposedTodo = ExposedTodo(
        description = description,
        due = due,
        name = userName
    )

}
