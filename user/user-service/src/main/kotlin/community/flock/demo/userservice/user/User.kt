package community.flock.demo.userservice.user

import community.flock.demo.userapi.user.ImmutableUser
import community.flock.demo.userservice.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import community.flock.demo.userapi.user.User as ExposedUser
import community.flock.demo.userapi.user.UserInfo as PotentialUser

@Table("users")
data class User(
        @Id val id: Long? = null,

        val name: String,
        val birthday: LocalDate
) : Exposable<ExposedUser> {

    constructor(user: PotentialUser) : this(
            name = user.name,
            birthday = LocalDate.parse(user.birthday)
    )

    constructor(user: Map<String, Any>) : this(
            user["id"] as Long,
            user["name"] as String,
            user["birthday"] as LocalDate
    )

    override fun expose(): ExposedUser = ImmutableUser.builder()
            .name(name)
            .birthday(birthday.toString())
            .build()

}

internal fun PotentialUser.consume() = User(this)
internal fun Map<String, Any>.internalize() = User(this)
