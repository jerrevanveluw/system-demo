package community.flock.demo.userservice.user

import community.flock.demo.userapi.user.input.Birthday
import community.flock.demo.userapi.user.output.ImmutableUser
import community.flock.demo.userservice.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDate
import java.time.Period
import community.flock.demo.userapi.user.output.User as ExposedUser

@Table("users")
data class User(
        @Id val id: Long? = null,

        val name: String,
        val birthday: LocalDate
) : Exposable<ExposedUser> {

    constructor(name: String, birthday: Birthday) : this(
            name = name,
            birthday = LocalDate.of(birthday.year, birthday.month, birthday.day)
    )

    constructor(map: Map<String, Any>) : this(
            map["id"] as Long,
            map["name"] as String,
            map["birthday"] as LocalDate
    )

    override fun expose(): ExposedUser = ImmutableUser.builder()
            .name(name)
            .age(Period.between(birthday, LocalDate.now()).years)
            .build()

}

internal fun Birthday.consume(name: String) = User(name, this)
internal fun Map<String, Any>.internalize() = User(this)
