package vm.counter

import vm.component.Component
import vm.props.android.*
import vm.review.android.ITextView
import vm.vnode.VNode
import vm.vnode.h

class Counter : PlatformComponent, Component<CounterProps?, CounterState>(CounterState(0)) {
    override var props: CounterProps? = null

    lateinit var textView: ITextView

    private val handleClick = {
        state = CounterState(state.num + 1)
    }

    override fun updateView(newState: CounterState) {
        if (newState.num != state.num) {
            textView.setText(newState.num.toString())
        }
    }

    override fun renderAndroid(): VNode<*, *> {
        val textViewProps = TextViewProps(state.num.toString(), ref = { r ->
            textView = r as ITextView
        })
        return h("linearLayout", null,
                h("button", vm.props.android.ButtonProps(handleClick, "CLICK")),
                h("textView", textViewProps)
        )
    }

    override fun renderWeb() =
            h("div", null,
                    h("button", vm.props.web.ButtonProps(handleClick)),
                    h("span", null,
                            state.num.toString()
                    )
            )

}

class CounterProps(val num: Int)
data class CounterState(val num: Int)