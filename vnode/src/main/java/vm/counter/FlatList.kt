package vm.counter

import vm.component.Component
import vm.vnode.VNode
import vm.vnode.h

class FlatList : PlatformComponent, Component<FlatListProps, FlatListState>(FlatListState(0)) {
    override lateinit var props: FlatListProps

    override fun renderAndroid() = h("easyRecyclerView", props)

    override fun renderWeb() =
            h("div", null,
                    *arrayOfNulls<Any>(props.length).map(props.onRenderRow).toTypedArray()
            )
}

typealias RenderRowEvent = (args: Any?) -> VNode<*, *>
typealias UpdateRowEvent = (args: Any, position: Int) -> Unit

class FlatListProps(val length: Int,
                    val onRenderRow: RenderRowEvent,
                    val onUpdateRow: UpdateRowEvent)

data class FlatListState(val length: Int)