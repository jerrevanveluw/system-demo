package community.flock.demo.app.shell.configuration

import community.flock.demo.app.common.exceptions.AppException
import community.flock.demo.app.common.exceptions.InternalServerException
import community.flock.demo.app.common.exceptions.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException) = e.toResponse(NOT_FOUND)

    @ExceptionHandler(InternalServerException::class)
    fun handleAppException(e: InternalServerException) = e.toResponse(HttpStatus.INTERNAL_SERVER_ERROR)

    private fun AppException.toResponse(status: HttpStatus) = ResponseEntity(message!!, headers, status)
        .also { printStackTrace() }

    private val headers = HttpHeaders().apply {
        contentType = MediaType.APPLICATION_JSON
        cacheControl = "private, max-age=0, no-cache, no-store"
    }

}
