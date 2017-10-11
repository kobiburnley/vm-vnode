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

    override fun renderAndroid() = h<IRecyclerProps>(RECYCLER) {
        attributes = RecyclerProps(props) {
            ref = { child ->
                recycler = child as IRecycler
                recycler.length = props.length
            }
        }
    }

    override fun renderWeb() =
            h<Unit>("div") {
                +arrayOfNulls<Any>(props.length).map(props.onRenderRow)
            }
}

typealias RenderRowEvent = (args: Any?) -> VNode<*, *>
typealias UpdateRowEvent = (args: ReView, position: Int) -> Unit

interface IFlatListProps : IViewProps {
    val length: Int
    val onRenderRow: RenderRowEvent
    val onUpdateRow: UpdateRowEvent
}

open class FlatListProps : ViewProps, IFlatListProps {
    final override var length: Int = 0
    final override lateinit var onRenderRow: RenderRowEvent
    final override lateinit var onUpdateRow: UpdateRowEvent

    constructor() : super()

    constructor(init: FlatListProps.() -> Unit) : this() {
        init()
    }

    constructor(flatListProps: IFlatListProps) : super(flatListProps) {
        length = flatListProps.length
        onRenderRow = flatListProps.onRenderRow
        onUpdateRow = flatListProps.onUpdateRow
    }
}

data class FlatListState(val length: Int)
