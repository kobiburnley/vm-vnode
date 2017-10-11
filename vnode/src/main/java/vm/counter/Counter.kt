package vm.counter

import iview.ITextView
import vm.component.Component
import vm.props.android.*
import vm.vnode.*

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
        return h<Unit>(LINEAR) {
            +h<IButtonProps>(BUTTON) {
                attributes = ButtonProps {
                    title = "CLICK"
                    onClick = handleClick

                }
            }
            +h<ITextViewProps>(TEXT) {
                attributes = TextViewProps {
                    text = state.num.toString()
                    ref = { r ->
                        textView = r as ITextView
                    }
                }
            }
        }
    }

    override fun renderWeb() =
            h<Unit>("div") {
                +h<ButtonProps>("button") {
                    ButtonProps {
                        title = "CLICK"
                        onClick = handleClick
                    }
                }
                +h<Unit>("span") {
                    +state.num.toString()
                }
            }

}

class CounterProps(val num: Int)
data class CounterState(val num: Int)
