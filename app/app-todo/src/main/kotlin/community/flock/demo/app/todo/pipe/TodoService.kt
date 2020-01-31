package community.flock.demo.app.todo.pipe

import org.springframework.stereotype.Service

@Service
class TodoService(private val adapter: TodoAdapter) {

    fun getTodos() = adapter.getTodos()

    fun getTodosFor(userName: String) = adapter.getTodos().filter { it.userName == userName }

}
