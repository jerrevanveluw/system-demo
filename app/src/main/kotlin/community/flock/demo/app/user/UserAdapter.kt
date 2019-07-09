package community.flock.demo.app.user

import org.openapitools.client.api.UserApi
import org.openapitools.client.model.User
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Repository

@Repository
class UserAdapter(@Qualifier("UserClient") private val client: UserApi) {

    fun getUsers(): List<User> = client.users

}
