package community.flock.demo.app.shell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import community.flock.demo.app.todo.Configuration as TodoConfiguration
import community.flock.demo.app.user.Configuration as UserConfiguration

@SpringBootApplication
@Import(value = [
    UserConfiguration::class,
    TodoConfiguration::class
])
class AppApplication

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}
