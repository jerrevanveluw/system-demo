package community.flock.demo.userservice.usefull

import org.springframework.http.ResponseEntity

val naturals = generateSequence(0) { it + 1 }.asIterable()

fun <T> Exposable<T>.toResponse() = ResponseEntity.ok(expose())

fun <T> List<Exposable<T>>.toResponse() = ResponseEntity.ok(map { it.expose() })

