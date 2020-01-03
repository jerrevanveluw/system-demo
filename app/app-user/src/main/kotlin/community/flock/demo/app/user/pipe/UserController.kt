package community.flock.demo.app.user.pipe

import community.flock.demo.app.common.usefull.toResponse
import community.flock.demo.app.user.data.consume
import org.springframework.web.bind.annotation.*
import community.flock.demo.app.common.generated.UserForm as PotentialUser


@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getUsers() = userService.getUsers().toResponse()

    @GetMapping("europe")
    fun getUsersFromEU() = userService.getUsersFromEU().toResponse()

    @GetMapping("usa")
    fun getUsersFromUS() = userService.getUsersFromUS().toResponse()


    @GetMapping("{name}")
    fun getUserByName(@PathVariable name: String) = userService.getUserByName(name).toResponse()

    @PostMapping
    fun postUser(@RequestBody user: PotentialUser) = user.consume().let { userService.save(it) }.toResponse()

}
