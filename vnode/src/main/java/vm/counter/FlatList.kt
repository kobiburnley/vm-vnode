package vm.counter

import iview.IRecycler
import vm.component.Component
import vm.props.android.*
import vm.vnode.RECYCLER
import vm.vnode.VNode
import vm.vnode.h

class FlatList : PlatformComponent, Component<FlatListProps, FlatListState>(FlatListState(0)) {
    override lateinit var props: FlatListProps
    lateinit var recycler: IRecycler

    override fun updateView(newState: FlatListState) {
        recycler.length = newState.length
    }

    override fun renderAndroid() = h(RECYCLER, RecyclerProps(
            flatListProps = props,
            viewProps = ViewProps(layoutParams = props.layoutParams, ref = { child ->
                recycler = child as IRecycler
            })
    ))

    override fun renderWeb() =
            h("div", null) {
                +arrayOfNulls<Any>(props.length).map(props.onRenderRow)
            }
}

typealias RenderRowEvent = (args: Any?) -> VNode<*, *>
typealias UpdateRowEvent = (args: Any, position: Int) -> Unit

class FlatListProps(val length: Int,
                    val onRenderRow: RenderRowEvent,
                    val onUpdateRow: UpdateRowEvent,
                    val viewProps: ViewProps = ViewProps()) : IViewProps by viewProps

data class FlatListState(val length: Int)