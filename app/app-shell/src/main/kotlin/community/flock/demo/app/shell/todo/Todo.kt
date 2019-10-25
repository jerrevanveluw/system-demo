package community.flock.demo.app.shell.todo

import community.flock.demo.app.common.usefull.Exposable

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

class ExposedTodo(
        val description: String,
        val due: String,
        val name: String?
)
