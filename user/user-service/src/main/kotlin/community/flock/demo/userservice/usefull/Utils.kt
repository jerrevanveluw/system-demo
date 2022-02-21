package community.flock.demo.userservice.usefull

val naturals = generateSequence(0) { it + 1 }.asIterable()

fun <T : Any> Exposable<T>.toResponse(): T = expose()

fun <T : Any> List<Exposable<T>>.toResponse(): List<T> = map { it.expose() }
