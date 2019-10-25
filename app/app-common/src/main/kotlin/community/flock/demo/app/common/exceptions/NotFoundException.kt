package community.flock.demo.app.common.exceptions

open class NotFoundException(thing: String) : AppException("$thing not found.")
