package community.flock.demo.app.configuration

import community.flock.demo.app.exceptions.TodoNotFoundException
import community.flock.demo.app.exceptions.UserNotFoundException
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    private fun handleUserNotFoundException(e: UserNotFoundException) = notFound(e.message)

    @ExceptionHandler(TodoNotFoundException::class)
    private fun handleTodoNotFoundException(e: TodoNotFoundException) = notFound(e.message)

    private fun notFound(msg: String?) = ResponseEntity(msg, NOT_FOUND)

}
