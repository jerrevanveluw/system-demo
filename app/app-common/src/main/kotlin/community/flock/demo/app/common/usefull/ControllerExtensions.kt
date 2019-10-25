package community.flock.demo.app.common.usefull

import org.springframework.http.ResponseEntity

fun <T> List<Exposable<T>>.toResponse(): ResponseEntity<List<T>> = ResponseEntity.ok(map { it.expose() })

fun <T> Exposable<T>.toResponse(): ResponseEntity<T> = ResponseEntity.ok(expose())
