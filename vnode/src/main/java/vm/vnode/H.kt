package vm.vnode

var customH: ((nodeName: Any, props: Any?, children: Array<*>?) -> VNode<*, *>)? = null

fun h(nodeName: String) = customH?.invoke(nodeName, Unit, null) ?: VNodeSimple(nodeName, Unit)

fun <P : Any> h(nodeName: String, props: P, init: VNode<P, *>.() -> Unit): VNode<P, *> {
    val vnode = VNodeSimple(nodeName, props)
    vnode.init()
    return (customH?.invoke(nodeName, props, vnode.nodes.toArray()) ?: vnode) as VNode<P, *>
}

fun <P : Any> h(nodeName: String, init: VNode<P, *>.() -> Unit): VNode<P, *> {
    val vnode = VNodeSimple<P>(nodeName)
    vnode.init()
    return (customH?.invoke(nodeName, vnode.attributes, vnode.nodes.toArray()) ?: vnode) as VNode<P, *>
}

//
//fun <P> h(nodeName: ComponentClass<P>, props: P, vararg children: Any?) =
//        customH?.invoke(nodeName, props, children) ?: VNodeComponent(nodeName, props, arrayListOf(*children))

fun <P : Any> h(nodeName: ComponentClass<P>, props: P, init: VNode<P, *>.() -> Unit): VNode<*, *> {
    val vnode = VNodeComponent(nodeName, props)
    vnode.init()
    return customH?.invoke(nodeName, props, vnode.nodes.toArray()) ?: vnode
}

fun <P : Any> h(nodeName: ComponentClass<P>, init: VNode<P, *>.() -> Unit): VNodeComponent<P> {
    val vnode = VNodeComponent<P>(nodeName)
    vnode.init()
    return (customH?.invoke(nodeName, vnode.attributes, vnode.nodes.toArray()) ?: vnode) as VNodeComponent<P>
}

//fun h(nodeName: ComponentClass<P>): VNodeComponent<P> = (customH?.invoke(nodeName, Unit, null) ?: VNodeComponent(nodeName, Unit)) as VNodeComponent<P>
