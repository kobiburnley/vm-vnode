package vm.vnode

data class VNode<P>(
        val nodeName: Any,
        val props: P? = null,
        val children: List<Any?>? = null
)