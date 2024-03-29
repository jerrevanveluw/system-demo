package community.flock.demo.app.user.data

import community.flock.demo.app.common.usefull.Producible
import community.flock.demo.app.common.usefull.Externalizable
import java.time.LocalDate
import java.time.Period
import community.flock.demo.app.common.generated.User as ProducedUser
import community.flock.demo.app.common.generated.UserForm as PotentialUser
import org.openapitools.client.model.User as ExternalUser
import org.openapitools.client.model.UserBody as ExternalisedUser

data class User(
    val name: String,
    val birthday: LocalDate,
    val metadata: UserMetadata? = null
) : Producible<ProducedUser>, Externalizable<ExternalisedUser> {

    constructor(user: PotentialUser) : this(
        name = user.name,
        birthday = LocalDate.of(user.year, user.month, user.day)
    )

    override fun produce() = ProducedUser(
        name = name,
        age = Period.between(birthday, LocalDate.now()).years,
        favouriteColour = metadata?.favoriteColour
    )

    constructor(user: ExternalUser) : this(
        name = user.name,
        birthday = LocalDate.parse(user.birthday),
        metadata = user.metadata.internalize()
    )

    constructor(user: ExternalDailyFableUser) : this(
        name = user.name,
        birthday = LocalDate.parse(user.birthday),
        metadata = user.color.internalize()
    )

    override fun externalize(): ExternalisedUser = ExternalisedUser().apply {
        name = name
        birthday = birthday.toString()
    }

}

fun ExternalUser.internalize() = User(this)

fun ExternalDailyFableUser.internalize() = User(this)

fun PotentialUser.consume() = User(this)

data class ExternalDailyFableUser(
    val name: String,
    val birthday: String,
    val color: String?
)
