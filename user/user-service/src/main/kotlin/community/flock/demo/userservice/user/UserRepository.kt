package community.flock.demo.userservice.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.core.*
import org.springframework.stereotype.Repository

@Repository
@FlowPreview
@ExperimentalCoroutinesApi
class UserRepository(private val client: DatabaseClient) {

    fun findAll(): Flow<User> = client.select().from("users").asType<User>().fetch().flow()

    suspend fun save(user: User): User = client.insert().into<User>().using(user).fetch().awaitOne().internalize()

}
