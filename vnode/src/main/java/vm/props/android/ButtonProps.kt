package vm.props.android

interface IButtonProps : ITextViewProps {
    val title: String
    val bg: Int
}

class ButtonProps(init: ButtonProps.() -> Unit) : IButtonProps, TextViewProps() {
    override lateinit var title: String
    override var bg: Int = -1

    init {
        init()
    }
}
