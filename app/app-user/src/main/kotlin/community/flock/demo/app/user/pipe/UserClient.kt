package community.flock.demo.app.user.pipe

import org.openapitools.client.api.UserApi
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component

@Component
class UserClient(env: Environment) : UserApi() {

    init {
        val host: String = env.getRequiredProperty("service.user.host")
        val port: String = env.getRequiredProperty("service.user.port")
        apiClient.basePath = "http://$host:$port"
    }

}
