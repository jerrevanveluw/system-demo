package community.flock.demo.app.shell

import community.flock.demo.app.todo.EnableTodoModule
import community.flock.demo.app.user.EnableUserModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableTodoModule
@EnableUserModule
@SpringBootApplication
class AppApplication

fun main(args: Array<String>) {
    runApplication<AppApplication>(*args)
}
