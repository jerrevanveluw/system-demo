package community.flock.demo.todo.todo

import community.flock.demo.todo.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("todos")
class Todo(

        @Id val id: Long,

        val description: String,
        val due: Long

) : Exposable<Todo.Exposed> {

    override fun expose(): Exposed = Exposed(description, due)

    class Exposed(
            val description: String,
            val due: Long
    )

}
