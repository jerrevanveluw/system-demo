package community.flock.demo.app.user

import community.flock.demo.app.usefull.toResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val service: UserService) {

    @GetMapping
    fun getUsers() = service.getUsers().toResponse()

    @GetMapping("europe")
    fun getUsersFromEU() = service.getUsersFromEU().toResponse()

    @GetMapping("usa")
    fun getUsersFromUS() = service.getUsersFromUS().toResponse()


    @GetMapping("{name}")
    fun getUserByName(@PathVariable name: String) = service.getUserByName(name).toResponse()

    @PostMapping
    fun postUser(@RequestBody user: PotentialUser) = user.consume().let { service.save(it) }.toResponse()

}
