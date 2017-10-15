package vm.props.android

interface ITextViewProps: IViewProps {
    var text: String
    var textColor: Int
    var textSize: Float
}

open class TextViewProps : ITextViewProps, ViewProps {
    override var text: String = ""
    override var textColor: Int = -1
    override var textSize: Float = -1F

    constructor() : super()

    constructor(init: TextViewProps.() -> Unit): this() {
        init()
    }
}
