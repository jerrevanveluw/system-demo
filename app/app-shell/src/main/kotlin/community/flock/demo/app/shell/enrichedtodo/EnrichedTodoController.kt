package community.flock.demo.app.shell.enrichedtodo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todos/{name}")
class EnrichedTodoController(private val enrichedTodoService: EnrichedTodoService) {

    @GetMapping
    fun getEnrichedTodosFor(@PathVariable name: String) =
        enrichedTodoService.getEnrichedTodosFor(name.capitalize()).map { it.expose() }

}
