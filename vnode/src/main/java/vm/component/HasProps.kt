package vm.component

import iview.IView

interface HasProps<P> : IRenderable {
    var props: P
    var view: IView
    var container: IContainer
}