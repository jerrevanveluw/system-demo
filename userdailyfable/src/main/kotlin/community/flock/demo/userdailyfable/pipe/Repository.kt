package community.flock.demo.userdailyfable.pipe

import community.flock.demo.userdailyfable.common.exceptions.UserNotFoundException
import community.flock.demo.userdailyfable.data.User
import community.flock.demo.userdailyfable.data.internalize
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.core.*
import org.springframework.stereotype.Repository

@Repository
@FlowPreview
@ExperimentalCoroutinesApi
class Repository(private val client: DatabaseClient) {

    fun findAll(): Flow<User> = client.select().from("users").asType<User>().fetch().flow()

    suspend fun findUserByName(name: String) = client.execute()
        .sql("SELECT * FROM users WHERE name = :name")
        .bind("name", name)
        .asType<User>()
        .fetch()
        .awaitOneOrNull() ?: throw UserNotFoundException(name)

    suspend fun save(user: User): User = client.insert().into<User>().using(user).fetch().awaitOne().internalize()

}
