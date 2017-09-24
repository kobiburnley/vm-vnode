package vm.vnode

var customH: ((nodeName: Any, props: Any?, children: Array<*>?) -> VNode<*, *>)? = null

fun <P> h(nodeName: String, props: P, vararg children: Any?): VNode<*, *> =
        customH?.invoke(nodeName, props, children) ?: VNodeSimple<P>(nodeName, props, children.asList())

fun h(nodeName: String, props: Any? = null) = h(nodeName = nodeName, props = props, children = null)

fun <P> h(nodeName: ComponentClass<P>, props: P, vararg children: Any?) =
        customH?.invoke(nodeName, props, children) ?: VNodeComponent(nodeName, props, children.asList())

fun <P> h(nodeName: ComponentClass<P>, props: P) = h(nodeName, props, null)
fun <P> h(nodeName: ComponentClass<P?>) = h(nodeName, null)
