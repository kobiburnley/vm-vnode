package vm.component

import vm.render.Platform
import xkotlin.js.JsName

interface IComponent<P, S> : HasProps<P>, ILifeCycle<P> {
    @JsName("mState")
    var state: S

    override fun componentWillUnmount() {}
    override fun componentDidMount() {}
    override fun componentWillMount() {}
    override fun componentWillReceiveProps(newProps: P) {}

    fun updateView(newState: S) {}

    @JsName("setState")
    fun _setState(newState: S) {
        when (Platform.platform) {
            Platform.WEB -> stateSetter!!.invoke(this, newState)
            else -> updateView(newState)
        }
    }
}