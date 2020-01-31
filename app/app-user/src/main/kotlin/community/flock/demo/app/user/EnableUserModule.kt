package community.flock.demo.app.user

import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Configuration as SpringConfiguration

@MustBeDocumented
@SpringConfiguration
@Import(UserConfiguration::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class EnableUserModule
