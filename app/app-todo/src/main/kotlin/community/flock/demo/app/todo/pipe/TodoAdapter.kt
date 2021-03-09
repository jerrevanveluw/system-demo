package community.flock.demo.app.todo.pipe

import community.flock.demo.app.common.usefull.AdapterType
import community.flock.demo.app.common.usefull.oops
import community.flock.demo.app.common.usefull.typeReference
import community.flock.demo.app.todo.data.Todo
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository

@Repository
class TodoAdapter(private val client: TodoClient) {

    internal fun getTodos() = guard { client.get(typeReference<List<Todo>>()) }

    private fun <T> TodoClient.get(type: ParameterizedTypeReference<T>) =
        exchange("/api", HttpMethod.GET, null, type).body
            ?: throw RuntimeException("404 todo not found")

    private fun <R> guard(block: () -> R) = AdapterType.TODO.oops(block)

}
