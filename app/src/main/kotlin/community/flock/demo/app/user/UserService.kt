package community.flock.demo.app.user

import org.springframework.stereotype.Service

@Service
class UserService(private val adapter: UserAdapter) {

    fun getUsers() = adapter.getUsers()

    fun getUserByName(name: String) = adapter.getUserByName(name)

    fun save(user: User) = adapter.save(user)

}
