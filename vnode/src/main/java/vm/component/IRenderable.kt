package vm.component

import vm.vnode.VNode
import xkotlin.js.JsName

interface IRenderable {
    @JsName("render")
    fun render(): Any?
}
