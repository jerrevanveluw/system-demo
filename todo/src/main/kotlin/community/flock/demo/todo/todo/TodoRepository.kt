package community.flock.demo.todo.todo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.core.*
import org.springframework.stereotype.Repository

@Repository
@FlowPreview
@ExperimentalCoroutinesApi
class TodoRepository(private val client: DatabaseClient) {

    fun findAll(): Flow<Todo> = client.select().from("todos").asType<Todo>().fetch().flow()

    suspend fun save(todo: Todo): Todo = client.insert().into<Todo>().using(todo).fetch().awaitOne().internalize()

}
