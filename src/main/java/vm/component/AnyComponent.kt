package vm.component

import xkotlin.js.JsName

var setState: ((component: Any, state: Any) -> Unit)? = null

interface IAnyProps<S : Any> {
    val viewManager: ViewManager<S>
}

abstract class AnyProps<S : Any>(override val viewManager: ViewManager<S>) : IAnyProps<S>

abstract class AnyComponent<S : Any, P : IAnyProps<S>>(val props: P) {
    var mState = defaultState()
        set(value) {
            val env = if (this.base != null) "react" else if (this.view != null) "vanilla" else null
            when (env) {
                "react" -> setState!!.invoke(this, value)
                else -> this.updateView(value)
            }
            field = value
        }
    var base: Any? = null
    var view: Any? = null

    fun updateView(newState: S) {
        props.viewManager.updateView(newState)
    }

    abstract fun defaultState(): S

    @JsName("componentDidMount")
    open fun componentDidMount() {}

    @JsName("componentWillReceiveProps")
    open fun componentWillReceiveProps(nextProps: P) {}
}
