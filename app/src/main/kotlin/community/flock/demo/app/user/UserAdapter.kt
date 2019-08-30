package community.flock.demo.app.user

import community.flock.demo.app.usefull.AdapterType.USER
import community.flock.demo.app.usefull.oops
import org.openapitools.client.api.UserApi
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

@Repository
class UserAdapter(@Qualifier("UserClient") private val client: UserApi) {

    fun getUsers() = guard { client.users }.map { it.internalize() }

    fun getUserByName(name: String) = guard { client.getUserByName(name) }.internalize()

    fun save(user: User) = guard { client.postUser(user.externalize()) }.internalize()

    private fun <R> guard(block: () -> R) = USER.oops(block)

}
