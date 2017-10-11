package vm.props.android

interface IButtonProps : IViewProps {
    val title: String
}

class ButtonProps(init: ButtonProps.() -> Unit) : IButtonProps, ViewProps() {
    override lateinit var title: String

    init {
        init()
    }
}
