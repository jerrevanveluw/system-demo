package community.flock.demo.app.user.configuration

import org.openapitools.client.api.UserApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:userService.properties")
class User(
        @Value("\${service.user.host}") private val userHost: String,
        @Value("\${service.user.port}") private val userPort: String
) {

    @Bean("UserClient")
    fun userClient(): UserApi = UserApi().apply {
        apiClient.basePath = "http://$userHost:$userPort"
    }

}