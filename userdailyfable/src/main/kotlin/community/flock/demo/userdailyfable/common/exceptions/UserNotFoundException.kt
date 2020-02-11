package community.flock.demo.userdailyfable.common.exceptions

class UserNotFoundException(name: String) : UserException("User with name $name not found")
