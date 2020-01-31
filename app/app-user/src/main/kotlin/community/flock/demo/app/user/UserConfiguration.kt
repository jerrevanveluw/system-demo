package community.flock.demo.app.user

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@ComponentScan(basePackages = ["community.flock.demo.app.user.pipe"])
@PropertySource("classpath:user.properties")
class UserConfiguration
