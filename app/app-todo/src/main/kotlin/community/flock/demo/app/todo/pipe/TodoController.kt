package community.flock.demo.app.todo.pipe

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos")
class TodoController(private val service: TodoService) {

    @GetMapping
    fun getTodos() = service.getTodos().map { it.produce() }

}
