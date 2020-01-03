package community.flock.demo.app.user

import community.flock.demo.app.user.pipe.UserController
import org.openapitools.client.api.UserApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan(basePackageClasses = [UserController::class])
@PropertySource("classpath:userService.properties")
class Configuration(
        @Value("\${service.host}") private val host: String,
        @Value("\${service.port}") private val port: String
) {

    @Bean
    fun userClient(): UserApi = UserApi().apply {
        apiClient.basePath = "http://$host:$port"
    }

}
