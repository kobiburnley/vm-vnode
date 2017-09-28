package vm.vnode

import org.junit.Assert.*
import vm.counter.Counter
import vm.counter.CounterProps
import vm.render.Platform
import vm.render.general.GeneralRenderer

class HKtTest {
    @org.junit.Test
    fun hTest() {
        Platform.platform = Platform.UNKNOWN
        val counterNode = h(::Counter, CounterProps(num = 2)) {
            +h("div", null) {
                h("div") {

                }
            }
            +h("div", null) {
                h("div", null) {

                }
            }
        }

        println(GeneralRenderer.render(counterNode))


    }
}
