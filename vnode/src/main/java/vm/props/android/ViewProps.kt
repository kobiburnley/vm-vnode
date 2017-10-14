package vm.props.android

import iview.Visibility


typealias RefFun = (any: Any) -> Unit
interface IRefProps {
    var ref: RefFun?
}

open class RefProps(override var ref: RefFun? = null) : IRefProps

interface IViewProps : IRefProps {
    val id: Int
    val bgColor: Int
    val paddingTop: Int
    val paddingRight: Int
    val paddingBottom: Int
    val paddingLeft: Int
    val padding: Int
    val minHeight: Int
    val top: Int
    val visibility: Int
    val onClick: (() -> Unit)?
    val layoutParams: ILayoutParams
}

open class ViewProps : IViewProps {
    companion object {
        @JvmField
        val EMPTY = ViewProps()
    }

    override var id: Int = -1
    override var bgColor: Int = -1
    override var paddingTop: Int = 0
    override var paddingRight: Int = 0
    override var paddingBottom: Int = 0
    override var paddingLeft: Int = 0
    override var padding: Int = 0
    override var minHeight: Int = -1
    override var top: Int = -1
    override var visibility: Int = Visibility.VISIBLE
    override var onClick: (() -> Unit)? = null
    override var layoutParams: ILayoutParams = ReLayoutParams()
    override var ref: RefFun? = null

    constructor()

    constructor(init: ViewProps.() -> Unit): this() {
        init()
    }

    constructor(viewProps: IViewProps, init: ViewProps.() -> Unit) : this(viewProps) {
        init()
    }

    constructor(viewProps: IViewProps): this() {
        id = viewProps.id
        bgColor = viewProps.bgColor
        paddingTop = viewProps.paddingTop
        paddingRight = viewProps.paddingRight
        paddingBottom = viewProps.paddingBottom
        paddingLeft = viewProps.paddingLeft
        padding = viewProps.padding
        top = viewProps.top
        visibility = viewProps.visibility
        onClick = viewProps.onClick
        layoutParams = viewProps.layoutParams
        ref = viewProps.ref
    }
}
