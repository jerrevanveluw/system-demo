package community.flock.demo.userservice.user

import community.flock.demo.userapi.user.UserApi
import community.flock.demo.userapi.user.output.User
import community.flock.demo.userservice.usefull.toResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.flow.asPublisher
import kotlinx.coroutines.runBlocking
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import community.flock.demo.userapi.user.input.User as PotentialUser


@FlowPreview
@RestController
@ExperimentalCoroutinesApi
@RequestMapping(value = ["/api"], produces = [APPLICATION_JSON_VALUE])
class UserController(private val service: UserService) : UserApi {

    @GetMapping
    override fun getUsers(): List<User> = runBlocking {
        service.findAll().toList().toResponse()
    }

    @GetMapping("{name}")
    override fun getUserByName(@PathVariable name: String): User = runBlocking {
        service.findUserByName(name).toResponse()
    }

    @PostMapping
    override fun postUser(@RequestBody user: PotentialUser): User = runBlocking {
        user.consume().let { service.save(it) }.toResponse()
    }

}
