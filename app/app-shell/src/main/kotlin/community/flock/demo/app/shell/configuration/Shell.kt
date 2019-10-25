package community.flock.demo.app.shell.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.client.RestTemplate

@Configuration
@PropertySource("classpath:services.properties")
class Shell(
        @Value("\${service.todo.host}") private val todoHost: String,
        @Value("\${service.todo.port}") private val todoPort: String
) {

    @Bean("TodoClient")
    fun todoClient(builder: RestTemplateBuilder): RestTemplate = builder
            .rootUri("http://$todoHost:$todoPort")
            .build()

}
