package vm.util.emitter

import java.util.ArrayList
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentLinkedQueue

class Emitter : IEmitter {

    private val callbacks = ConcurrentHashMap<String, ConcurrentLinkedQueue<Listener>>()

    override fun on(event: String, fn: Listener): Emitter {
        var callbacks: ConcurrentLinkedQueue<Listener>? = this.callbacks[event]
        if (callbacks == null) {
            callbacks = ConcurrentLinkedQueue()
            val tempCallbacks = (this.callbacks as java.util.Map<String, ConcurrentLinkedQueue<Listener>>).put(event, callbacks)
            if (tempCallbacks != null) {
                callbacks = tempCallbacks
            }
        }
        callbacks.add(fn)
        return this
    }

//    fun once(event: String, fn: Listener): Emitter {
//        this.on(event, onceListener(event, fn))
//        return this
//    }

    fun off(): Emitter {
        this.callbacks.clear()
        return this
    }

    override fun off(event: String): Emitter {
        this.callbacks.remove(event)
        return this
    }

    override fun off(event: String, fn: Listener): Emitter {
        val callbacks = this.callbacks[event]
        if (callbacks != null) {
            val it = callbacks.iterator()
            while (it.hasNext()) {
                val internal = it.next()
                if (sameAs(fn, internal)) {
                    it.remove()
                    break
                }
            }
        }
        return this
    }

    private fun sameAs(fn: Listener, internal: Listener): Boolean {
        return if (fn == internal) {
            true
        } else {
            false
        }
    }

    override fun emit(event: String, vararg args: Any): Emitter {
        val callbacks = this.callbacks[event]
        if (callbacks != null) {
            for (fn in callbacks) {
                fn(args)
            }
        }
        return this
    }

    fun listeners(event: String): List<Listener> {
        val callbacks = this.callbacks[event]
        return if (callbacks != null)
            ArrayList(callbacks)
        else
            ArrayList(0)
    }

    override fun hasListeners(event: String): Boolean {
        val callbacks = this.callbacks[event]
        return callbacks != null && !callbacks.isEmpty()
    }


//    fun onceListener(event: String, fn: Listener) = lambda@ fun Listener.(args: Array<out Any>) {
//        this@Emitter.off(event, this)
//        fn(args)
//    }
}