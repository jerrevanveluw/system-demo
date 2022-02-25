package community.flock.demo.userservice.usefull

val naturals = generateSequence(0) { it + 1 }.asIterable()

fun <T : Any> Producible<T>.toResponse(): T = produce()

fun <T : Any> List<Producible<T>>.toResponse(): List<T> = map { it.produce() }
