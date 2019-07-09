package community.flock.demo.userservice.user

import community.flock.demo.userapi.user.UserApi
import community.flock.demo.userapi.user.input.Birthday
import community.flock.demo.userapi.user.output.User
import community.flock.demo.userservice.usefull.toResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@FlowPreview
@RestController
@ExperimentalCoroutinesApi
@RequestMapping(value = ["/api"], produces = [APPLICATION_JSON_VALUE])
class UserController(private val service: UserService) : UserApi {

    @GetMapping
    override fun getUsers(): ResponseEntity<List<User>> = runBlocking { service.findAll().toList().toResponse() }


    @PostMapping("{userName}")
    override fun postUser(@PathVariable userName: String, @RequestBody birthday: Birthday): ResponseEntity<User> = runBlocking {
        service.save(birthday.consume(userName)).toResponse()
    }

}
