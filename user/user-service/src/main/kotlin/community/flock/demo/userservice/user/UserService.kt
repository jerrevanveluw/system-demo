package community.flock.demo.userservice.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.springframework.stereotype.Service

@Service
@FlowPreview
@ExperimentalCoroutinesApi
class UserService(private val repository: UserRepository) {

    fun findAll() = repository.findAll()

    suspend fun save(user: User) = repository.save(user)

}
