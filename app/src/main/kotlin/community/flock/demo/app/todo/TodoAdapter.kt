package community.flock.demo.app.todo

import community.flock.demo.app.usefull.AdapterType.TODO
import community.flock.demo.app.usefull.oops
import community.flock.demo.app.usefull.typeReference
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class TodoAdapter(@Qualifier("TodoClient") private val client: RestTemplate) {

    fun getTodos() = TODO.oops { client.get(typeReference<List<Todo>>()) }

    private fun <T> RestTemplate.get(type: ParameterizedTypeReference<T>) = exchange("/api", HttpMethod.GET, null, type).body
            ?: throw RuntimeException("404 todo not found")

}
