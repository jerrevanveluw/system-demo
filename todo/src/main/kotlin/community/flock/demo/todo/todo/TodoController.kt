package community.flock.demo.todo.todo

import community.flock.demo.todo.usefull.toResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.*

@FlowPreview
@RestController
@ExperimentalCoroutinesApi
@RequestMapping("/api")
class TodoController(private val service: TodoService) {

    @GetMapping
    fun getTodos() = service.findAll().map { it.expose() }

    @PostMapping
    fun postTodo(@RequestBody todo: PotentialTodo) = runBlocking {
        todo.consume().let { service.save(it) }.toResponse()
    }

}
