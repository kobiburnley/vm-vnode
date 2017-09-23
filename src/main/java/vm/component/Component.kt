package vm.component

abstract class Component<P, S>(private val defaultState: S) : IComponent<P, S> {
    override var state: S = this.defaultState
        set(value) {
            _setState(value)
            field = value
        }
}
