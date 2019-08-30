package community.flock.demo.todo.todo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@FlowPreview
@RestController
@ExperimentalCoroutinesApi
@RequestMapping("/api")
class TodoController(private val service: TodoService) {

    @GetMapping
    fun getTodos() = service.findAll().map { it.expose() }

}
