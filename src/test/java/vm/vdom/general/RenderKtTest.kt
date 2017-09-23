package vm.vdom.general

import org.junit.Test

import vm.component.Component
import vm.component.IComponent
import vm.vnode.h
import kotlin.reflect.KFunction0


class RenderKtTest {
    @Test
    fun renderTest() {
        val rc = RenderComponent()
        println(GeneralRenderer.renderComponent(rc, "World"))
//        println(render(h(RenderComponent())))
    }

}

class RenderComponent : Component<String, Any?>(null) {
    override var state: Any? = Unit
    override var props: String = ""

    override fun render() = h(
            "button", null,
            h("span", null,
                    """Hello $props"""
            ),
            "nothing",
            h(::ChildComponent, "Hello",
                    "44444444"
            )

    )
}


class ChildComponent: IComponent<String, Any> {
    override var state: Any = Unit
    override var props: String = ""

    override fun render() = h(
            "a", null,
            h("h1", null,
                    """Hello $props"""
            )
    )
}
