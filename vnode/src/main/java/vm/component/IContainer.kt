package vm.component

import iview.IEditText
import vm.util.emitter.IEmitter
import vm.vnode.VNode

interface IContainer : IEmitter {
    fun alert(s: String)
    fun getActivity(): Any
    fun dismissKeyboard(view: IEditText)
    fun routeTo(id: String, tag: String, data: HashMap<String, String>?)
}
