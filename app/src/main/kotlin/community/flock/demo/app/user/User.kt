package community.flock.demo.app.user

import community.flock.demo.app.usefull.Exposable
import community.flock.demo.app.usefull.Externalizable
import java.time.LocalDate
import java.time.Period
import org.openapitools.client.model.User as External
import org.openapitools.client.model.UserInfo as Externalised


class User(
        private val name: String,
        private val birthday: LocalDate
) : Exposable<User.Exposed>, Externalizable<Externalised> {

    constructor(user: Potential) : this(
            name = user.name,
            birthday = LocalDate.of(user.year, user.month, user.day)
    )

    constructor(user: External) : this(
            name = user.name,
            birthday = LocalDate.parse(user.birthday)
    )

    override fun expose(): Exposed = Exposed(
            name = name,
            age = Period.between(birthday, LocalDate.now()).years
    )

    override fun externalize() = Externalised().also {
        it.name = name
        it.birthday = birthday.toString()
    }

    class Exposed(
            val name: String,
            val age: Int
    )

    class Potential(
            val name: String,
            val year: Int,
            val month: Int,
            val day: Int
    )

}

fun User.Potential.consume() = User(this)
fun External.internalize() = User(this)
