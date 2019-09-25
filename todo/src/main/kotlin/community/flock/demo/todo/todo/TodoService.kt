package community.flock.demo.todo.todo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.springframework.stereotype.Service

@Service
@FlowPreview
@ExperimentalCoroutinesApi
class TodoService(private val repository: TodoRepository) {

    fun findAll() = repository.findAll()

    suspend fun save(todo: Todo) = repository.save(todo)

}
