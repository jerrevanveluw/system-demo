package community.flock.demo.app.user.pipe

import community.flock.demo.app.common.usefull.AdapterType.USER
import community.flock.demo.app.common.usefull.oops
import community.flock.demo.app.user.data.User
import community.flock.demo.app.user.data.internalize
import org.springframework.stereotype.Repository

@Repository
class UserAdapter(private val client: UserClient) {

    fun getUsers() = guard { client.users }.map { it.internalize() }

    fun getUserByName(name: String) = guard { client.getUserByName(name) }.internalize()

    fun save(user: User) = guard { user.externalize().let { client.postUser(it) } }.internalize()

    companion object {
        private fun <R> guard(block: () -> R) = USER.oops(block)
    }

}
