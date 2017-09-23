package vm.vdom

import vm.component.IRenderable
import vm.vnode.VNode

interface Renderer<V> {
    fun render(any: Any?): V
    fun <P> renderComponent(component: IRenderable<P>, props: P): V
    fun <P> renderVNode(vNode: VNode<P>): V
    fun walkSimple(vNode: VNode<*>): V
}