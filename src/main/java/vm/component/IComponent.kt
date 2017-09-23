package vm.component

import xkotlin.js.JsName

interface IComponent<P, S>: IRenderable<P>, ILifeCycle<P> {
    @JsName("mState")
    var state: S

    override fun componentDidMount() {}
    override fun componentWillMount() {}
    override fun componentWillReceiveProps(newProps: P) {}

    @JsName("setState")
    fun updateView(newState: S) {
        stateSetter!!.invoke(this, newState)
    }
}