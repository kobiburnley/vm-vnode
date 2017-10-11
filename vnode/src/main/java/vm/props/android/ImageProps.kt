package vm.props.android

interface IImageProps : IViewProps {
    val resource: Int
}

open class ImageProps() : IImageProps, ViewProps() {
    override var resource: Int = 0

    constructor(init: ImageProps.() -> Unit) : this() {
        init()
    }
}
