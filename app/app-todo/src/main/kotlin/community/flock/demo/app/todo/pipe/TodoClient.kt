package community.flock.demo.app.todo.pipe

import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import org.springframework.web.client.RestOperations
import org.springframework.web.client.RestTemplate

@Component
class TodoClient(
        env: Environment,
        builder: RestTemplateBuilder
) : RestOperations by client(env, builder) {

    companion object {
        fun client(env: Environment, builder: RestTemplateBuilder): RestTemplate = builder.run {
            val host: String = env.getRequiredProperty("service.todo.host")
            val port: String = env.getRequiredProperty("service.todo.port")
            rootUri("http://$host:$port")
        }.build()
    }

}
