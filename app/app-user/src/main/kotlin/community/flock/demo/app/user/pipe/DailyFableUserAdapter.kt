package community.flock.demo.app.user.pipe

import community.flock.demo.app.common.usefull.AdapterType
import community.flock.demo.app.common.usefull.oops
import community.flock.demo.app.common.usefull.typeReference
import community.flock.demo.app.user.data.ExternalDailyFableUser
import community.flock.demo.app.user.data.internalize
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.web.client.HttpClientErrorException

@Repository
class DailyFableUserAdapter(private val client: DailyFableUserClient) {

    internal fun getUsers() = guard { client.get(typeReference<List<ExternalDailyFableUser>>()) }
        .map { it.internalize() }

    internal fun getUserByName(name: String) = guard { client.getByName(name) }
        .internalize()


    private fun <T> DailyFableUserClient.get(type: ParameterizedTypeReference<T>) =
        exchange("/api", GET, null, type).body
            ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND)

    private fun DailyFableUserClient.getByName(name: String) =
        exchange("/api/$name", GET, null, ExternalDailyFableUser::class.java).body
            ?: throw HttpClientErrorException(HttpStatus.NOT_FOUND)

    private fun <R> guard(block: () -> R) = AdapterType.DF_USER.oops(block)

}
