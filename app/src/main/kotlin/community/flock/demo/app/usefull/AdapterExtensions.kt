package community.flock.demo.app.usefull

import community.flock.demo.app.exceptions.InternalServerException
import community.flock.demo.app.exceptions.TodoNotFoundException
import community.flock.demo.app.exceptions.UserNotFoundException
import community.flock.demo.app.usefull.AdapterType.TODO
import community.flock.demo.app.usefull.AdapterType.USER
import org.springframework.core.ParameterizedTypeReference
import org.springframework.web.client.HttpClientErrorException

inline fun <reified T> typeReference() = object : ParameterizedTypeReference<T>() {}

fun <R> AdapterType.oops(block: () -> R) = try {
    block()
} catch (e: HttpClientErrorException) {
    when (e.rawStatusCode) {
        404 -> throwNotFoundException()
        else -> throw InternalServerException()
    }
} catch (e: Exception) {
    throw InternalServerException()
}


private fun AdapterType.throwNotFoundException(): Nothing = throw when (this) {
    USER -> UserNotFoundException()
    TODO -> TodoNotFoundException()
}

enum class AdapterType {
    USER, TODO
}
