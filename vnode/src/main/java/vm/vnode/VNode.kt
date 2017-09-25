package vm.vnode

import vm.component.HasProps

typealias ComponentClass<P> = () -> HasProps<P>

abstract class VNode<P, T>(
        val nodeName: T,
        val props: P,
        val children: List<Any?>? = null
)

class VNodeSimple<P>(nodeName: String, props: P, children: List<Any?>?) : VNode<P, String>(nodeName, props, children)

class VNodeComponent<P>(nodeName: ComponentClass<P>, props: P, children: List<Any?>?) : VNode<P, ComponentClass<P>>(nodeName, props, children)