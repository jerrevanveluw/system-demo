package community.flock.demo.app.todo

import community.flock.demo.app.todo.pipe.TodoController
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.client.RestTemplate

@Configuration
@ComponentScan(basePackageClasses = [TodoController::class])
@PropertySource("classpath:todoService.properties")
class Configuration(
        @Value("\${service.todo.host}") private val host: String,
        @Value("\${service.todo.port}") private val port: String
) {

    @Bean
    fun todoClient(builder: RestTemplateBuilder): RestTemplate = builder
            .rootUri("http://$host:$port")
            .build()

}
