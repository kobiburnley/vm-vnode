package vm.component

import iview.IView
import vm.vnode.VNode

abstract class Component<P, S>(private val defaultState: S) : IComponent<P, S> {
    override lateinit var children: ArrayList<Any?>
    override lateinit var view: IView
    override lateinit var container: IContainer

    override var state: S = this.defaultState
        set(value) {
            _setState(value)
            field = value
        }
}
