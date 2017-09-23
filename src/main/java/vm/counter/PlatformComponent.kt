package vm.counter

import vm.component.HasProps
import vm.component.IRenderable
import vm.vdom.Platform
import vm.vnode.VNode

interface PlatformComponent: IRenderable {
    fun renderAndroid(): VNode<*>
    fun renderWeb(): VNode<*>

    override fun render(): VNode<*> = when (Platform.platform) {
        Platform.ANDROID -> renderAndroid()
        Platform.WEB -> renderWeb()
        else -> throw Exception("platform not set")
    }
}