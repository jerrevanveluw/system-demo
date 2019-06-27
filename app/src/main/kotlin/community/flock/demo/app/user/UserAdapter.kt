package community.flock.demo.app.user

import community.flock.demo.app.usefull.typeReference
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class UserAdapter(@Qualifier("UserClient") private val client: RestTemplate) {

    fun getUsers() = client.exchange("/api", GET, null, typeReference<List<User>>()).body
            ?: throw RuntimeException("404 user not found")

}
