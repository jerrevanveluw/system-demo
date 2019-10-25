package community.flock.demo.app.shell

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["community.flock.demo.app"])
class AppApplication

fun main(args: Array<String>) {
	runApplication<AppApplication>(*args)
}
