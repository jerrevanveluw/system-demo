package community.flock.demo.app.usefull

import community.flock.demo.app.exceptions.AppException
import community.flock.demo.app.exceptions.InternalServerException
import community.flock.demo.app.exceptions.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ControllerAdvice {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException) = e.toResponse(NOT_FOUND)

    @ExceptionHandler(InternalServerException::class)
    fun handleAppException(e: InternalServerException) = e.toResponse(INTERNAL_SERVER_ERROR)


    private fun AppException.toResponse(status: HttpStatus) = ResponseEntity(message!!, headers, status)
            .also { printStackTrace() }

    private val headers = HttpHeaders().apply {
        contentType = APPLICATION_JSON
        cacheControl = "private, max-age=0, no-cache, no-store"
    }

}
