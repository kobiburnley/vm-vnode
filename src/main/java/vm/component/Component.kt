package vm.component

abstract class Component<P, S>(private val defaultState: S) : IComponent<P, S> {
    override var state: S = this.defaultState
        set(value) {
            updateView(value)
            field = value
        }
}
