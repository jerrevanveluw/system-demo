package community.flock.demo.userdailyfable.pipe

import community.flock.demo.userdailyfable.data.consume
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import org.springframework.web.bind.annotation.*
import community.flock.demo.userdailyfable.data.ProducedUser as PotentialUser

@FlowPreview
@RestController
@ExperimentalCoroutinesApi
@RequestMapping("/api")
class Controller(private val service: Service) {

    @GetMapping
    fun getAll() = service.findAll().map { it.produce() }

    @GetMapping("{name}")
    suspend fun getUserByName(@PathVariable name: String) = service.findUserByName(name)

    @PostMapping
    suspend fun postUser(@RequestBody user: PotentialUser) = service.save(user.consume())

}
