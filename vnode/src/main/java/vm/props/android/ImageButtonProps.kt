package vm.props.android


interface IImageButtonProps : IImageProps {
}

open class ImageButtonProps() : IImageButtonProps, ImageProps() {
    constructor(init: ImageButtonProps.() -> Unit) : this() {
        init()
    }
}
