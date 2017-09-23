package vm.component

import vm.vnode.VNode
import xkotlin.js.JsName

interface IRenderable<P> {
    var props: P

    @JsName("render")
    fun render(): VNode<*>
}