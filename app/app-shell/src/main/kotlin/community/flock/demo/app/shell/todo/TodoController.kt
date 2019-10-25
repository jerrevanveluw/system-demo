package community.flock.demo.app.shell.todo

import community.flock.demo.app.shell.enrichedtodo.EnrichedTodoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(
        private val service: TodoService,
        private val enrichedTodoService: EnrichedTodoService
) {

    @GetMapping
    fun getTodos() = service.getTodos().map { it.expose() }

    @GetMapping("{name}")
    fun getEnrichedTodosFor(@PathVariable name: String) = enrichedTodoService.getEnrichedTodosFor(name.capitalize()).map { it.expose() }

}
