package vm.vnode

import vm.component.HasProps

typealias ComponentClass<P> = () -> HasProps<P>

abstract class VNode<P, T: Any>(
        val nodeName: T,
        val attributes: P,
        val _children: ArrayList<Any?> = arrayListOf()
) {
    operator fun String.unaryPlus() {
        this@VNode._children.add(this@unaryPlus)
    }

    operator fun VNode<*, *>.unaryPlus() {
        this@VNode._children.add(this@unaryPlus)
    }

    operator fun Collection<Any?>.unaryPlus() {
        this@VNode._children.addAll(this@unaryPlus)
    }

    override fun equals(other: Any?): Boolean {
        return other is VNode<*, *> &&
        nodeName == other?.nodeName &&
                attributes?.equals(other?.attributes) ?: false &&
                _children.equals(other?._children)
    }
}

class VNodeSimple<P>(nodeName: String, attributes: P, children: ArrayList<Any?> = arrayListOf()) : VNode<P, String>(nodeName, attributes, children)

class VNodeComponent<P>(nodeName: ComponentClass<P>, attributes: P, children: ArrayList<Any?> = arrayListOf()) : VNode<P, ComponentClass<P>>(nodeName, attributes, children)