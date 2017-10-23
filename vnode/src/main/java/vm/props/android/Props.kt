package vm.props.android

import iview.Visibility
import vm.component.IComponent
import vm.component.IRenderable
import vm.counter.FlatListProps
import vm.render.IRenderer
import javax.swing.text.View

interface ReView {
    var component: IRenderable?
}

@JvmField
val MATCH_PARENT = -1
@JvmField
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
        val weight: Float = 0F,
        val gravity: Int = -1
) : ILayoutParams

