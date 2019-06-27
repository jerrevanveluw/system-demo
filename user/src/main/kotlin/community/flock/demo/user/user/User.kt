package community.flock.demo.user.user

import community.flock.demo.user.usefull.Exposable
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("users")
data class User(

        @Id val id: Long? = null,

        val name: String,
        val age: Int

) : Exposable<User.Exposed> {

    constructor(map: Map<String, Any>) : this(
            map["id"] as Long,
            map["name"] as String,
            (map["age"] as Long).toInt()
    )

    override fun expose() = Exposed(name, age)

    class Exposed(
            val name: String,
            val age: Int
    )

}

internal fun Map<String, Any>.internalize() = User(this)