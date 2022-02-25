package community.flock.demo.app.common.usefull

import org.springframework.http.ResponseEntity

fun <T> List<Producible<T>>.toResponse(): ResponseEntity<List<T>> = respond(map { it.produce() })

fun <T> Producible<T>.toResponse(): ResponseEntity<T> = respond(produce())

private fun <R> respond(body: R): ResponseEntity<R> = ResponseEntity.ok(body)
