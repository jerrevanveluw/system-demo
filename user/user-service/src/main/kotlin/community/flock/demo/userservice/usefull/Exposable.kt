package community.flock.demo.userservice.usefull

interface Exposable<T : Any> {

    fun expose(): T

}
