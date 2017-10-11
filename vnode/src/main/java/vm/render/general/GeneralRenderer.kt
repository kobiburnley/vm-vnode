package vm.render.general

import vm.component.IComponent
import vm.component.HasProps
import vm.vnode.VNode
import kotlin.reflect.KFunction0

object GeneralRenderer  {
    fun render(any: Any?): String = when (any) {
        is String -> any
        is VNode<*, *> -> renderVNode(any)
        else -> throw IllegalArgumentException(any?.toString())
    }

    fun <P> renderComponent(component: HasProps<P>, props: P): String {
        if (component is IComponent<P, *>) {
            component.componentWillReceiveProps(props)
        }
        component.props = props
        val s = render(component.render())
        if (component is IComponent<P, *>) {
            component.componentDidMount()
        }
        return s
    }

    fun <P: Any> renderVNode(vNode: VNode<P, *>): String {
        val nodeName = vNode.nodeName
        return when (nodeName) {
            is KFunction0<*> -> renderComponent<P>(nodeName.invoke() as HasProps<P>, vNode.attributes as P)
            is String -> walkSimple(vNode)
            else -> throw IllegalArgumentException("nodeName must be renderable or string")
        }
    }

    fun walkSimple(vNode: VNode<*, *>): String {
        val nodeName = vNode.nodeName
        val attributes = vNode.attributes?.toString()
        val children = vNode.nodes?.map(GeneralRenderer::render)?.joinToString("\n") ?: "***"
        return """<$nodeName $attributes>
        |$children
        |</$nodeName>""".trimMargin()
    }
}