package vm.vnode

import vm.component.HasProps

typealias ComponentClass<P> = () -> HasProps<P>

interface IVNode<P : Any, T : Any> {
    val nodeName: T
    var attributes: P
    var nodes: ArrayList<Any?>
}

abstract class VNode<P : Any, T : Any>(val nodeName: T) {
    lateinit var attributes: P
    var nodes: ArrayList<Any?> = arrayListOf()

    constructor(nodeName: T, attributes: P, nodes: ArrayList<Any?> = arrayListOf()) : this(nodeName) {
        this.attributes = attributes
        this.nodes = nodes
    }

    operator fun String.unaryPlus() {
        this@VNode.nodes.add(this@unaryPlus)
    }

    operator fun VNode<*, *>.unaryPlus() {
        this@VNode.nodes.add(this@unaryPlus)
    }

    operator fun Collection<Any?>.unaryPlus() {
        this@VNode.nodes.addAll(this@unaryPlus)
    }
//
//    override fun equals(other: Any?): Boolean {
//        return other is VNode<*, *> &&
//                nodeName == other.nodeName &&
//                attributes.equals(other.attributes) &&
//                nodes.equals(other.nodes)
//    }
}

class VNodeSimple<P : Any>(nodeName: String) : VNode<P, String>(nodeName) {
    constructor(nodeName: String, attributes: P, nodes: ArrayList<Any?> = arrayListOf()) : this(nodeName) {
        this.attributes = attributes
        this.nodes = nodes
    }
}

class VNodeComponent<P : Any>(nodeName: ComponentClass<P>) : VNode<P, ComponentClass<P>>(nodeName) {
    constructor(nodeName: ComponentClass<P>, attributes: P, children: ArrayList<Any?> = arrayListOf()) : this(nodeName) {
        this.attributes = attributes
        this.nodes = nodes
    }
}
