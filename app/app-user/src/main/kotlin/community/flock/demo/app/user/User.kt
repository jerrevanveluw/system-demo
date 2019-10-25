package community.flock.demo.app.user

import community.flock.demo.app.common.usefull.Exposable
import community.flock.demo.app.common.usefull.Externalizable
import java.time.LocalDate
import java.time.Period
import org.openapitools.client.model.User as ExternalUser
import org.openapitools.client.model.UserBody as ExternalisedUser

data class User(
        val name: String,
        val birthday: LocalDate,
        val metadata: UserMetadata? = null
) : Exposable<ExposedUser>, Externalizable<ExternalisedUser> {

    constructor(user: PotentialUser) : this(
            name = user.name,
            birthday = LocalDate.of(user.year, user.month, user.day)
    )

    override fun expose(): ExposedUser = ExposedUser(
            name = name,
            age = Period.between(birthday, LocalDate.now()).years,
            favouriteColour = metadata?.favoriteColour
    )

    constructor(user: ExternalUser) : this(
            name = user.name,
            birthday = LocalDate.parse(user.birthday),
            metadata = user.metadata.internalize()
    )

    override fun externalize(): ExternalisedUser = ExternalisedUser().also {
        it.name = name
        it.birthday = birthday.toString()
    }

}

fun ExternalUser.internalize() = User(this)

fun PotentialUser.consume() = User(this)

data class PotentialUser(
        val name: String,
        val year: Int,
        val month: Int,
        val day: Int
)

data class ExposedUser(
        val name: String,
        val age: Int,
        val favouriteColour: String?
)
