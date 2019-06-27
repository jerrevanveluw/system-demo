package community.flock.demo.user.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.asType
import org.springframework.data.r2dbc.core.flow
import org.springframework.data.r2dbc.core.into
import org.springframework.stereotype.Repository

@Repository
@FlowPreview
@ExperimentalCoroutinesApi
class UserRepository(private val client: DatabaseClient) {

    fun findAll() = client.select().from("users").asType<User>().fetch().flow()

    fun save(user: User) = client.insert().into<User>().using(user).fetch().flow().map { it.internalize() }

}
