package community.flock.demo.app.todo

import org.springframework.stereotype.Service

@Service
class TodoService(private val adapter: TodoAdapter) {

    fun getTodos() = adapter.getTodos()

}