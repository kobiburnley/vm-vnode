package vm.vnode

import vm.component.HasProps

typealias ComponentClass<P> = () -> HasProps<P>

abstract class VNode<P, T>(
        val nodeName: T,
        val props: P,
        val children: ArrayList<Any?>? = arrayListOf()
) {
    operator fun Any.unaryPlus() {
        children?.add(this@unaryPlus)
    }
}

class VNodeSimple<P>(nodeName: String, props: P, children: ArrayList<Any?>? = arrayListOf()) : VNode<P, String>(nodeName, props, children)

class VNodeComponent<P>(nodeName: ComponentClass<P>, props: P, children: ArrayList<Any?>? = arrayListOf()) : VNode<P, ComponentClass<P>>(nodeName, props, children)