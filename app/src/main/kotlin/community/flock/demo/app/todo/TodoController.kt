package community.flock.demo.app.todo

import community.flock.demo.app.enrichedtodo.EnrichedTodoService
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
