package community.flock.demo.userservice.configuration

import community.flock.demo.userservice.exceptions.UserNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(UserNotFoundException::class)
    private fun handleAcceptLongException(e: UserNotFoundException) = ResponseEntity(e.message, HttpStatus.NOT_FOUND)

}
