package community.flock.demo.app.user

import community.flock.demo.app.usefull.AdapterType.USER
import community.flock.demo.app.usefull.oops
import org.openapitools.client.api.UserApi
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

@Repository
class UserAdapter(@Qualifier("UserClient") private val client: UserApi) {

    fun getUsers() = USER.oops { client.users }.map { it.internalize() }

    fun getUserByName(name: String) = USER.oops { client.getUserByName(name) }.internalize()

    fun save(user: User) = USER.oops { client.postUser(user.externalize()) }.internalize()

}
