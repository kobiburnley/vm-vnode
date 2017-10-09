package vm.props.android

import iview.Visibility
import vm.component.IComponent
import vm.component.IRenderable
import vm.counter.FlatListProps
import vm.render.IRenderer
import javax.swing.text.View

typealias RefFun = (any: Any) -> Unit
interface IRefProps {
    var ref: RefFun?
}

open class RefProps(override var ref: RefFun? = null) : IRefProps

interface ReView {
    var component: IRenderable?
}

val MATCH_PARENT = -1
val WRAP_CONTENT = -2


interface ILayoutParams {
    val height: Int
    val width: Int
}

class ReLayoutParams(
        override val height: Int = MATCH_PARENT,
        override val width: Int = MATCH_PARENT
) : ILayoutParams


class RelativeLayoutParams(
        override val height: Int = MATCH_PARENT,
        override val width: Int = MATCH_PARENT,
        val toLeftOf: Int = -1,
        val toRightOf: Int = -1,
        var below: Int = -1,
        val centerHorizontal: Boolean = false,
        val centerVertical: Boolean = false,
        val alignParentLeft: Boolean = false,
        val alignParentRight: Boolean = false,
        val alignParentTop: Boolean = false
) : ILayoutParams

class LinearLayoutParams(
        override val height: Int = MATCH_PARENT,
        override val width: Int = MATCH_PARENT,
        val weight: Float = 0F
) : ILayoutParams

interface IViewProps : IRefProps {
    val id: Int
    val bgColor: Int
    val paddingTop: Int
    val paddingRight: Int
    val paddingBottom: Int
    val paddingLeft: Int
    val padding: Int
    val visibility: Int
    val onClick: (() -> Unit)?
    val layoutParams: ILayoutParams
}

class ViewProps(
        override val id: Int = -1,
        override val bgColor: Int = -1,
        override val paddingTop: Int = 0,
        override val paddingRight: Int = 0,
        override val paddingBottom: Int = 0,
        override val paddingLeft: Int = 0,
        override val padding: Int = 0,
        override val visibility: Int = Visibility.VISIBLE,
        override val onClick: (() -> Unit)? = null,
        override val layoutParams: ILayoutParams = ReLayoutParams(),
        ref: RefFun? = null
) : IViewProps, RefProps(ref)

class ButtonProps(val title: String,
                  val viewProps: ViewProps = ViewProps()
) : IViewProps by viewProps

class TextViewProps(val text: String,
                    val viewProps: ViewProps = ViewProps()
) : IViewProps by viewProps

class EditTextProps(
        val viewProps: ViewProps = ViewProps()
) : IViewProps by viewProps

class RecyclerProps(
        val flatListProps: FlatListProps,
        val viewProps: ViewProps = ViewProps()
) : IViewProps by viewProps


interface IImageProps : IViewProps {
    val resource: Int
}

class ImageProps(override val resource: Int = 0, val viewProps: ViewProps = ViewProps()) : IImageProps, IViewProps by viewProps
