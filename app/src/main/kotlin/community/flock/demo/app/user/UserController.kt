package community.flock.demo.app.user

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val service: UserService) {

    @GetMapping
    fun getUsers() = service.getUsers().map { it.expose() }

    @GetMapping("{name}")
    fun getUserByName(@PathVariable name: String) = service.getUserByName(name).expose()

    @PostMapping
    fun postUser(@RequestBody user: User.Potential) = service.save(user.consume()).expose()

}
