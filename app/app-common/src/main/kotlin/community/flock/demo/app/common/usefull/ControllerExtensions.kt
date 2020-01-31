package community.flock.demo.app.common.usefull

import org.springframework.http.ResponseEntity

fun <T> List<Exposable<T>>.toResponse(): ResponseEntity<List<T>> = respond(map { it.expose() })

fun <T> Exposable<T>.toResponse(): ResponseEntity<T> = respond(expose())

private fun <R> respond(body: R): ResponseEntity<R> = ResponseEntity.ok(body)
