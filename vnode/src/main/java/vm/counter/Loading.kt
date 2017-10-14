package vm.counter

import iview.IView
import iview.Visibility
import vm.component.Component
import vm.component.HasProps
import vm.props.android.*
import vm.vnode.RELATIVE
import vm.vnode.SPINNER
import vm.vnode.VNode
import vm.vnode.h
import java.lang.Exception

class Loading : PlatformComponent, Component<LoadingProps, LoadingState>(LoadingState(loading = false, hasData = false)) {
    override lateinit var props: LoadingProps
    lateinit var spinner: IView
    lateinit var inner: IView

    override fun renderAndroid() = h<ViewProps>(RELATIVE) {
        attributes = ViewProps {
            layoutParams = props.layoutParams
            bgColor = props.bgColor
        }
        +h<ViewProps>(SPINNER) {
            attributes = ViewProps {
                layoutParams = RelativeLayoutParams(centerHorizontal = true, centerVertical = true, height = 100, width = 100)
                ref = { args ->
                    spinner = args as IView
                }
            }
        }
        val vNode = props.body
        val oldRef = vNode.attributes.ref
        vNode.attributes.ref = {
            oldRef?.invoke(it)
            inner = when (it) {
                is HasProps<*> -> it.view
                is IView -> it
                else -> throw Exception()
            }
        }
        +vNode
    }

    override fun updateView(newState: LoadingState) {
        if (newState.loading) {
            spinner.setVisibility(Visibility.VISIBLE)
        } else if (newState.hasData) {
            spinner.setVisibility(Visibility.INVISIBLE)
        }
    }

    override fun renderWeb(): Any? = null

}

interface ILoadingProps : IViewProps {
    val body: VNode<out IRefProps, *>
    val loading: Boolean
    val hasData: Boolean
}

class LoadingProps(init: LoadingProps.() -> Unit) : ILoadingProps, ViewProps() {
    override lateinit var body: VNode<out IRefProps, *>
    override var loading: Boolean = false
    override var hasData: Boolean = false

    init {
        init()
    }
}

data class LoadingState(
        val loading: Boolean,
        val hasData: Boolean
)
