package community.flock.demo.userdailyfable.data

import community.flock.demo.userdailyfable.common.Exposable
import community.flock.demo.userdailyfable.data.ExposedUser
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import community.flock.demo.userdailyfable.data.ExposedUser as PotentialUser

@Table("users")
class User(
        @Id val id: Long? = null,

        val name: String,
        val birthday: LocalDate,
        val color: String = DEFAULT_COLOR
) : Exposable<ExposedUser> {

    constructor(user: PotentialUser) : this(
            name = user.name,
            birthday = LocalDate.parse(user.birthday),
            color = user.color ?: DEFAULT_COLOR
    )

    constructor(user: Map<String, Any>) : this(
            user["id"] as Long,
            user["name"] as String,
            user["birthday"] as LocalDate,
            user["color"] as String
    )

    override fun expose(): ExposedUser = ExposedUser(
            name = name,
            birthday = birthday.toString(),
            color = color
    )

    companion object {
        const val DEFAULT_COLOR = "none"
    }

}

internal fun Map<String, Any>.internalize() = User(this)
internal fun PotentialUser.consume() = User(this)

data class ExposedUser(
        val name: String,
        val birthday: String,
        val color: String?
)
