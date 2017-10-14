package vm.props.android

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

annotation class OrientationMode

object Orientation {
    @JvmField
    val HORIZONTAL = 0
    @JvmField
    val VERTICAL = 1
}

interface ILinearProps : IViewProps {
    var orientation: Int
}

class LinearProps : ILinearProps, ViewProps {
    override var orientation: Int = 0

    constructor(init: LinearProps.() -> Unit) : super() {
        init()
    }
}
