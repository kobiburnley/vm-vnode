package vm.props.android

interface IEditTextProps : IViewProps {
    var text: String
    val hint: String
    var onChange: ((text: String) -> Unit)?
}

class EditTextProps(init: EditTextProps.() -> Unit) : IEditTextProps, ViewProps() {
    override lateinit var text: String
    override lateinit var hint: String
    override var onChange: ((text: String) -> Unit)? = null

    init {
        init()
    }
}
