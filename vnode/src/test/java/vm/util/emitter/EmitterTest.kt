package vm.util.emitter

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by kobi on 11/10/17.
 */
class EmitterTest {
    val handleEvent: Listener = { }

    @Test
    @Throws(Exception::class)
    fun off() {
        println(handleEvent.equals(handleEvent))
        val list = ArrayList<Any>()
        list.add(handleEvent)
        list.remove(handleEvent)
        val emitter = Emitter()
        emitter.on("spc", handleEvent)
        assertEquals(1, emitter.listeners("spc").size)
        assertEquals(true, emitter.hasListeners("spc"))
        emitter.off("spc", handleEvent)
        assertEquals(0, emitter.listeners("spc").size)
        assertEquals(false, emitter.hasListeners("spc"))
    }

}