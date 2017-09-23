package vm.vnode

var customH: ((nodeName: Any, props: Any?, children: Array<*>?) -> VNode<*>)? = null

fun h(nodeName: Any, props: Any? = null, vararg children: Any?) = customH?.invoke(nodeName, props, children) ?: VNode(nodeName, props, children.asList())