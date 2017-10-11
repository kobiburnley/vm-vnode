package vm.util.emitter

typealias Listener = (args: Array<out Any>) -> Unit

interface IEmitter {
    fun on(event: String, fn: Listener): Emitter
    fun off(event: String): Emitter
    fun off(event: String, fn: Listener): Emitter
    fun emit(event: String, vararg args: Any): Emitter
    fun hasListeners(event: String): Boolean
}
