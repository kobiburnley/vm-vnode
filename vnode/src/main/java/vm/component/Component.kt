package vm.component

import iview.IView
import iview.Visibility

abstract class Component<P: Any, S>(private val defaultState: S) : IComponent<P, S> {
    override lateinit var props: P
    override lateinit var view: IView
    override lateinit var container: IContainer
    var x = Visibility.GONE

    override var state: S = this.defaultState
        set(value) {
            mSetState(value)
            field = value
        }
}
