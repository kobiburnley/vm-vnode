package vm.component

import iview.IEditText
import vm.util.emitter.IEmitter

interface IContainer : IEmitter {
    fun alert(s: String)
    fun dismissKeyboard(view: IEditText)
}
