package community.flock.demo.app.shell.todo

import org.springframework.stereotype.Service

@Service
class TodoService(private val adapter: TodoAdapter) {

    fun getTodos() = adapter.getTodos()

}