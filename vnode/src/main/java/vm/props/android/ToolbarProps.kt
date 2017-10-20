package vm.props.android

interface IToolbarProps : IViewProps {
    var titleTextColor: Int
}

class ToolbarProps : IToolbarProps, ViewProps {
    override var titleTextColor: Int = -1

    constructor(init: ToolbarProps.() -> Unit) {
        init()
    }
}
