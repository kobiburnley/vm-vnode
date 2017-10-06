package vm.props.android

import vm.component.IComponent
import vm.counter.FlatListProps
import vm.render.IRenderer

typealias RefFun = (any: Any) -> Unit
interface IRefProps {
    var ref: RefFun?
}

open class RefProps(override var ref: RefFun?) : IRefProps


val MATCH_PARENT = -1
val WRAP_CONTENT = -2

open class ReLayoutParams(
        val height: Int,
        val width: Int
) {
    class RelativeLayout(height: Int = MATCH_PARENT,
                         width: Int = MATCH_PARENT,
                         val toLeftOf: Int = -1,
                         val toRightOf: Int = -1,
                         val centerHorizontal: Boolean = false,
                         val centerVertical: Boolean = false) : ReLayoutParams(height, width)


}


open class ViewProps(
        val id: Int = 0,
        val paddingTop: Int = 0,
        val paddingRight: Int = 0,
        val paddingBottom: Int = 0,
        val paddingLeft: Int = 0,
        val layoutParams: ReLayoutParams = ReLayoutParams(MATCH_PARENT, MATCH_PARENT),
        ref: RefFun? = null
) : RefProps(ref)

class ButtonProps(val onClick: () -> Unit, val title: String,
                  id: Int = 0,
                  paddingTop: Int = 0,
                  paddingRight: Int = 0,
                  paddingBottom: Int = 0,
                  paddingLeft: Int = 0,
                  layoutParams: ReLayoutParams = ReLayoutParams(MATCH_PARENT, MATCH_PARENT),
                  ref: RefFun? = null
) : ViewProps(id, paddingTop, paddingRight, paddingBottom, paddingLeft, layoutParams, ref)

class TextViewProps(val text: String,
                    id: Int = 0,
                    paddingTop: Int = 0,
                    paddingRight: Int = 0,
                    paddingBottom: Int = 0,
                    paddingLeft: Int = 0,
                    layoutParams: ReLayoutParams = ReLayoutParams(MATCH_PARENT, MATCH_PARENT),
                    ref: RefFun? = null
) : ViewProps(id, paddingTop, paddingRight, paddingBottom, paddingLeft, layoutParams, ref)

class RecyclerProps(
        val flatListProps: FlatListProps,
        val viewProps: ViewProps = ViewProps()
) : IRefProps by viewProps