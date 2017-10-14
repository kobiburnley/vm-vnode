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
        val (length, position) = newState
        recycler.length = length
        recycler.position = position
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
typealias UpdateRowEvent = (review: ReView, position: Int, adapterPosition: Int) -> Unit
typealias ScrollEvent = (first: Int, total: Int) -> Unit
typealias ScrollStateChangeEvent = (newState: String) -> Unit

interface IFlatListProps : IViewProps {
    val length: Int
    val scroll: Boolean
    val onRenderRow: RenderRowEvent
    val onUpdateRow: UpdateRowEvent
    val onScroll: ScrollEvent?
    val onScrollStateChange: ScrollStateChangeEvent?
    val itemCacheSize: Int
}

open class FlatListProps : ViewProps, IFlatListProps {
    final override var length: Int = 0
    final override var scroll: Boolean = true
    final override lateinit var onRenderRow: RenderRowEvent
    final override lateinit var onUpdateRow: UpdateRowEvent
    final override var onScroll: ScrollEvent? = null
    final override var onScrollStateChange: ScrollStateChangeEvent? = null
    final override var itemCacheSize: Int = 2

    constructor() : super()

    constructor(init: FlatListProps.() -> Unit) : this() {
        init()
    }

    constructor(flatListProps: IFlatListProps) : super(flatListProps) {
        length = flatListProps.length
        onRenderRow = flatListProps.onRenderRow
        onUpdateRow = flatListProps.onUpdateRow
        scroll = flatListProps.scroll
        onScroll = flatListProps.onScroll
        onScrollStateChange = flatListProps.onScrollStateChange
        itemCacheSize = flatListProps.itemCacheSize
    }
}

data class FlatListState(val length: Int, val position: Int = 0)
