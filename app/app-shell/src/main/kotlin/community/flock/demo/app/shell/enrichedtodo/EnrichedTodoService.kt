package community.flock.demo.app.shell.enrichedtodo

import community.flock.demo.app.todo.pipe.TodoService
import community.flock.demo.app.user.pipe.UserService
import org.springframework.stereotype.Service

@Service
class EnrichedTodoService(
        private val todoService: TodoService,
        private val userService: UserService
) {

    fun getEnrichedTodosFor(userName: String): List<EnrichedTodo> = userService.getUserByName(userName).let { user ->
        todoService.getTodosFor(userName).map { it.enrichWith(user) }
    }

}
