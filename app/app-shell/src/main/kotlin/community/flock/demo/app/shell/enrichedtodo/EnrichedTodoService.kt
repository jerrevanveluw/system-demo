package community.flock.demo.app.shell.enrichedtodo

import community.flock.demo.app.todo.pipe.TodoService
import community.flock.demo.app.user.pipe.UserService
import org.springframework.stereotype.Service

@Service
class EnrichedTodoService(
        private val todoService: TodoService,
        private val userService: UserService
) {

    fun getEnrichedTodosFor(userName: String) = userService.getUserByName(userName).let { user ->
        todoService.getTodos()
                .filter { it.userName == userName }
                .map { EnrichedTodo(it, user) }
    }

}
