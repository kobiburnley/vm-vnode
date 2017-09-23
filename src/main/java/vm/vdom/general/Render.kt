package vm.vdom.general

import vm.component.IComponent
import vm.component.IRenderable
import vm.vnode.VNode
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction0

fun render(any: Any?): String = when (any) {
    is String -> any
    is VNode<*> -> renderVNode(any)
    else -> throw IllegalArgumentException(any?.toString())
}

fun <P> renderComponent(component: IRenderable<P>, props: P): String {
    if (component is IComponent<P, *>) {
        component.componentWillReceiveProps(props)
    }
    component.props = props
    val s = renderVNode(component.render())
    if (component is IComponent<P, *>) {
        component.componentDidMount()
    }
    return s
}

fun <P> renderVNode(vNode: VNode<P>): String {
    val nodeName = vNode.nodeName
    return when (nodeName) {
        is KFunction0<*> -> renderComponent<P>(nodeName.invoke() as IRenderable<P>, vNode.props as P)
        is String -> walkSimple(vNode)
        else -> throw IllegalArgumentException("nodeName must be renderable or string")
    }
}

fun walkSimple(vNode: VNode<*>): String {
    val nodeName = vNode.nodeName
    val attributes = vNode.props?.toString()
    val children = vNode.children?.map(::render)?.joinToString("\n") ?: "***"
    return """<$nodeName $attributes>
        |$children
        |</$nodeName>""".trimMargin()
}