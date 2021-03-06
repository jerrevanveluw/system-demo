package community.flock.demo.app.user.pipe

import community.flock.demo.app.common.exceptions.UserNotFoundException
import community.flock.demo.app.user.data.User
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Period

@Service
class UserService(private val sesameAdapter: SesameStreetUserAdapter, private val fableAdapter: DailyFableUserAdapter) {

    fun getUsers(): List<User> = sesameAdapter.getUsers() + fableAdapter.getUsers()

    fun getUsersFromEU() = getUsers().areOldEnoughToDrink(Region.EU)

    fun getUsersFromUS() = getUsers().areOldEnoughToDrink(Region.US)

    fun getUserByName(name: String) = runCatching { sesameAdapter.getUserByName(name) }.getOrNull()
        ?: runCatching { fableAdapter.getUserByName(name) }.getOrNull()
        ?: throw UserNotFoundException()


    fun save(user: User) = sesameAdapter.save(user)

    companion object {
        private fun List<User>.areOldEnoughToDrink(region: Region) = filter { it.age() > region.age }

        private fun User.age() = Period.between(birthday, LocalDate.now()).years

        private enum class Region(val age: Int) {
            US(21),
            EU(18)
        }
    }

}
