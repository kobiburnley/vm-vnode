package vm.vnode

var customH: ((nodeName: Any, props: Any?, children: Array<*>?) -> VNode<*, *>)? = null

fun <P> h(nodeName: String, props: P, vararg children: Any?): VNode<*, *> =
        customH?.invoke(nodeName, props, children) ?: VNodeSimple<P>(nodeName, props, arrayListOf(*children))

fun h(nodeName: String, props: Any? = null) = h(nodeName = nodeName, props = props, children = null)

fun <P> h(nodeName: String, props: P, init: VNode<*, *>.() -> Unit): VNode<*, *> {
    val vnode = VNodeSimple(nodeName, props)
    vnode.init()
    return customH?.invoke(nodeName, props, vnode.children?.toArray()) ?: vnode
}


fun <P> h(nodeName: ComponentClass<P>, props: P, vararg children: Any?) =
        customH?.invoke(nodeName, props, children) ?: VNodeComponent(nodeName, props, arrayListOf(*children))

fun <P> h(nodeName: ComponentClass<P>, props: P, init: VNode<*, *>.() -> Unit): VNode<*, *> {
    val vnode = VNodeComponent(nodeName, props)
    vnode.init()
    return customH?.invoke(nodeName, props, vnode.children?.toArray()) ?: vnode
}

fun <P> h(nodeName: ComponentClass<P>, props: P) = h(nodeName, props, children = null)
fun <P> h(nodeName: ComponentClass<P?>) = h(nodeName, null)
