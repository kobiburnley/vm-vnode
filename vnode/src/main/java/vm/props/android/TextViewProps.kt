package vm.props.android

interface ITextViewProps: IViewProps {
    var text: String
    var textColor: Int
    var textSize: Float
}

class TextViewProps(init: TextViewProps.() -> Unit) : ITextViewProps, ViewProps() {
    override var text: String = ""
    override var textColor: Int = -1
    override var textSize: Float = -1F

    init {
        init()
    }
}
