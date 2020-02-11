package community.flock.demo.userdailyfable.pipe

import community.flock.demo.userdailyfable.data.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.springframework.stereotype.Service

@Service
@FlowPreview
@ExperimentalCoroutinesApi
class Service(private val repository: Repository) {

    fun findAll() = repository.findAll()

    suspend fun findUserByName(name: String) = repository.findUserByName(name)

    suspend fun save(user: User) = repository.save(user)

}
