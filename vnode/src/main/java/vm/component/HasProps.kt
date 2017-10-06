package vm.component

import iview.IView

interface HasProps<P> : IRenderable {
    var props: P
    var children: ArrayList<Any?>
    var view: IView
}