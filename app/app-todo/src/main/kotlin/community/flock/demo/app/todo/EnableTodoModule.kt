package community.flock.demo.app.todo

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@MustBeDocumented
@Import(TodoConfiguration::class)
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
annotation class EnableTodoModule
