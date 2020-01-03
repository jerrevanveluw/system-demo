package community.flock.demo.app.user.pipe

import community.flock.demo.app.user.data.User
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.Period

@Service
class UserService(private val userAdapter: UserAdapter) {

    fun getUsers() = userAdapter.getUsers()

    fun getUsersFromEU() = getUsers().areOldEnoughToDrink(Region.EU)

    fun getUsersFromUS() = getUsers().areOldEnoughToDrink(Region.US)

    fun getUserByName(name: String) = userAdapter.getUserByName(name)

    fun save(user: User) = userAdapter.save(user)


    private fun List<User>.areOldEnoughToDrink(region: Region) = filter { it.age() > region.age }

    private fun User.age() = Period.between(birthday, LocalDate.now()).years

    private enum class Region(val age: Int) {
        US(21),
        EU(18)
    }

}
