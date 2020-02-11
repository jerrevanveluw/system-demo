package community.flock.demo.app.user

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@MustBeDocumented
@Import(UserConfiguration::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class EnableUserModule
