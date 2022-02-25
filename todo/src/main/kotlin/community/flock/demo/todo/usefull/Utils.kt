package community.flock.demo.todo.usefull

import org.springframework.http.ResponseEntity

fun <T> Producible<T>.toResponse(): ResponseEntity<T> = ResponseEntity.ok(produce())

fun <T> List<Producible<T>>.toResponse(): ResponseEntity<List<T>> = ResponseEntity.ok(map { it.produce() })
