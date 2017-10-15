package vm.props.android

interface IButtonProps : ITextViewProps {
    val title: String
}

class ButtonProps(init: ButtonProps.() -> Unit) : IButtonProps, TextViewProps() {
    override lateinit var title: String

    init {
        init()
    }
}
