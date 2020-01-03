package community.flock.demo.app.todo.pipe

import org.springframework.stereotype.Service

@Service
class TodoService(private val todoAdapter: TodoAdapter) {

    fun getTodos() = todoAdapter.getTodos()

}
