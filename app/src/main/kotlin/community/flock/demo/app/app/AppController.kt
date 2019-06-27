package community.flock.demo.app.app

import community.flock.demo.app.todo.TodoService
import community.flock.demo.app.user.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class AppController(
        private val userService: UserService,
        private val todoService: TodoService
) {

    @GetMapping("user")
    fun getUsers() = userService.getUsers()

    @GetMapping("todo")
    fun getTodos() = todoService.getTodos()

}
