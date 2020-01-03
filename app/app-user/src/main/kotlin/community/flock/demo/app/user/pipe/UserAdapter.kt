package community.flock.demo.app.user.pipe

import community.flock.demo.app.common.usefull.AdapterType.USER
import community.flock.demo.app.common.usefull.oops
import community.flock.demo.app.user.data.User
import community.flock.demo.app.user.data.internalize
import org.openapitools.client.api.UserApi
import org.springframework.stereotype.Repository

@Repository
class UserAdapter(private val userClient: UserApi) {

    fun getUsers() = guard { userClient.users }.map { it.internalize() }

    fun getUserByName(name: String) = guard { userClient.getUserByName(name) }.internalize()

    fun save(user: User) = guard { user.externalize().let { userClient.postUser(it) } }.internalize()


    private fun <R> guard(block: () -> R) = USER.oops(block)

}
