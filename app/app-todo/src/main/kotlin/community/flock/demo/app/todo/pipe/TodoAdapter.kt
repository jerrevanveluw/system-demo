package community.flock.demo.app.todo.pipe

import community.flock.demo.app.common.usefull.AdapterType
import community.flock.demo.app.common.usefull.oops
import community.flock.demo.app.common.usefull.typeReference
import community.flock.demo.app.todo.data.Todo
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class TodoAdapter(private val todoClient: RestTemplate) {

    fun getTodos() = guard { todoClient.get(typeReference<List<Todo>>()) }

    private fun <T> RestTemplate.get(type: ParameterizedTypeReference<T>) = exchange("/api", HttpMethod.GET, null, type).body
            ?: throw RuntimeException("404 todo not found")

    private fun <R> guard(block: () -> R) = AdapterType.TODO.oops(block)

}
