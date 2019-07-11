package community.flock.demo.todo.todo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.asType
import org.springframework.data.r2dbc.core.flow
import org.springframework.stereotype.Repository

@Repository
@FlowPreview
@ExperimentalCoroutinesApi
class TodoRepository(private val client: DatabaseClient) {

    fun findAll() = client.select().from("todos").asType<Todo>().fetch().flow()

}
