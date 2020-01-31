package community.flock.demo.app.todo

import org.springframework.context.annotation.Import
import org.springframework.context.annotation.Configuration as SpringConfiguration

@MustBeDocumented
@SpringConfiguration
@Import(TodoConfiguration::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class EnableTodoModule
