package vm.vdom.general

import vm.component.IComponent
import vm.component.HasProps
import vm.vdom.Renderer
import vm.vnode.VNode
import kotlin.reflect.KFunction0

object GeneralRenderer : Renderer<String> {
    override fun render(any: Any?): String = when (any) {
        is String -> any
        is VNode<*> -> renderVNode(any)
        else -> throw IllegalArgumentException(any?.toString())
    }

    override fun <P> renderComponent(component: HasProps<P>, props: P): String {
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

    override fun <P> renderVNode(vNode: VNode<P>): String {
        val nodeName = vNode.nodeName
        return when (nodeName) {
            is KFunction0<*> -> renderComponent<P>(nodeName.invoke() as HasProps<P>, vNode.props as P)
            is String -> walkSimple(vNode)
            else -> throw IllegalArgumentException("nodeName must be renderable or string")
        }
    }

    fun walkSimple(vNode: VNode<*>): String {
        val nodeName = vNode.nodeName
        val attributes = vNode.props?.toString()
        val children = vNode.children?.map(GeneralRenderer::render)?.joinToString("\n") ?: "***"
        return """<$nodeName $attributes>
        |$children
        |</$nodeName>""".trimMargin()
    }
}