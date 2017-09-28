package vm.counter

import vm.component.IRenderable
import vm.render.Platform
import vm.vnode.VNode

interface PlatformComponent : IRenderable {
    fun renderAndroid(): Any?
    fun renderWeb(): Any?

    override fun render() = when (Platform.platform) {
        Platform.ANDROID -> renderAndroid()
        else -> renderWeb()
    }
}