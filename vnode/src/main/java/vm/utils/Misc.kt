package vm.utils

object Misc {
    lateinit var setTimeout: (block: () -> Unit, ms: Long, timeoutId: Any?) -> Any
    lateinit var clearTimeout: (timeoutId: Any?) -> Unit

    fun debounce(block: () -> Unit, ms: Long) = Debounce(block, ms)
}

class Debounce(val block: () -> Unit, val ms: Long) {
    var timeoutId: Any? = null

    fun run() {
        if(timeoutId != null) {
            Misc.clearTimeout(timeoutId)
        }
        timeoutId = Misc.setTimeout(block, ms, timeoutId)
    }
}
