package vm.props.android

interface ITextViewProps: IViewProps {
    var text: String
    var textColor: Int
    var textSize: Float
    var gravity: Int
    var maxLines: Int
}

open class TextViewProps : ITextViewProps, ViewProps {
    override var text: String = ""
    override var textColor: Int = -1
    override var textSize: Float = -1F
    override var gravity: Int = -1
    override var maxLines: Int = -1

    constructor() : super()

    constructor(init: TextViewProps.() -> Unit): this() {
        init()
    }
}
