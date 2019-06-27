package community.flock.demo.user.user

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import org.springframework.web.bind.annotation.*

@FlowPreview
@RestController
@ExperimentalCoroutinesApi
@RequestMapping("/api")
class UserController(private val service: UserService) {

    @GetMapping
    fun getUsers() = service.findAll().map { it.expose() }

    @PostMapping("{user}/{age}")
    suspend fun postUser(@PathVariable user: String, @PathVariable age: Int) = service.save(User(name = user, age = age))

}
