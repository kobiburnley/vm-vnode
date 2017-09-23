package vm.vdom

import vm.component.HasProps
import vm.vnode.VNode

interface Renderer<V> {
    fun render(any: Any?): V
    fun <P> renderComponent(component: HasProps<P>, props: P): V
    fun <P> renderVNode(vNode: VNode<P>): V
}