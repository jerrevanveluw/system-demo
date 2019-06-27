package community.flock.demo.app.todo

import community.flock.demo.app.usefull.typeReference
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class TodoAdapter(@Qualifier("TodoClient") private val client: RestTemplate) {


    fun getTodos() = client.exchange("/api", HttpMethod.GET, null, typeReference<List<Todo>>()).body
            ?: throw RuntimeException("404 todo not found")

}
