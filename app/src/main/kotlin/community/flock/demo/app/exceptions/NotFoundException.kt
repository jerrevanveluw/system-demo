package community.flock.demo.app.exceptions

open class NotFoundException(thing: String) : AppException("$thing not found.")
