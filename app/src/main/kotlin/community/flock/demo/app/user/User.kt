package community.flock.demo.app.user

import community.flock.demo.app.usefull.Exposable
import community.flock.demo.app.usefull.Externalizable
import java.time.LocalDate
import java.time.Period
import org.openapitools.client.model.User as ExternalUser
import org.openapitools.client.model.UserBody as ExternalisedUser


class User(
        private val name: String,
        private val birthday: LocalDate
) : Exposable<ExposedUser>, Externalizable<ExternalisedUser> {

    constructor(user: PotentialUser) : this(
            name = user.name,
            birthday = LocalDate.of(user.year, user.month, user.day)
    )

    constructor(user: ExternalUser) : this(
            name = user.name,
            birthday = LocalDate.parse(user.birthday)
    )

    override fun expose(): ExposedUser = ExposedUser(
            name = name,
            age = Period.between(birthday, LocalDate.now()).years
    )

    override fun externalize() = ExternalisedUser().also {
        it.name = name
        it.birthday = birthday.toString()
    }

}

class ExposedUser(
        val name: String,
        val age: Int
)

class PotentialUser(
        val name: String,
        val year: Int,
        val month: Int,
        val day: Int
)

fun PotentialUser.consume() = User(this)
fun ExternalUser.internalize() = User(this)
