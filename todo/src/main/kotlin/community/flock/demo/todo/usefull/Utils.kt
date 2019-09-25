package community.flock.demo.todo.usefull

import org.springframework.http.ResponseEntity

fun <T> Exposable<T>.toResponse(): ResponseEntity<T> = ResponseEntity.ok(expose())

fun <T> List<Exposable<T>>.toResponse(): ResponseEntity<List<T>> = ResponseEntity.ok(map { it.expose() })
