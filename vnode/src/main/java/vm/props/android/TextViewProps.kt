package vm.props.android

interface ITextViewProps {
    var text: String
}

class TextViewProps(init: TextViewProps.() -> Unit) : ITextViewProps, ViewProps() {
    override lateinit var text: String

    init {
        init()
    }
}
