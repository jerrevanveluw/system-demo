package community.flock.demo.app.user.pipe

import community.flock.demo.app.common.usefull.AdapterType.USER
import community.flock.demo.app.common.usefull.oops
import community.flock.demo.app.user.data.User
import community.flock.demo.app.user.data.internalize
import org.springframework.stereotype.Repository

@Repository
class SesameStreetUserAdapter(private val sesameStreetClient: SesameStreetUserClient) {

    fun getUsers() = guard { sesameStreetClient.users }.map { it.internalize() }

    fun getUserByName(name: String) = guard { sesameStreetClient.getUserByName(name) }.internalize()

    fun save(user: User) = guard { user.externalize().let { sesameStreetClient.postUser(it) } }.internalize()

    companion object {
        private fun <R> guard(block: () -> R) = USER.oops(block)
    }

}
