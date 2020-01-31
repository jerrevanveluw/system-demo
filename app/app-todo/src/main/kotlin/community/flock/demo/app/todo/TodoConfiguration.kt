package community.flock.demo.app.todo

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@ComponentScan(basePackages = ["community.flock.demo.app.todo.pipe"])
@PropertySource("classpath:todo.properties")
class TodoConfiguration
