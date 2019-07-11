package community.flock.demo.userservice.exceptions

class UserNotFoundException(name: String) : UserException("User with name $name not found")
