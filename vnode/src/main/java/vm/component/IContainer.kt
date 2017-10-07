package vm.component

import drutils.emitter.IEmitter

interface IContainer: IEmitter {
    fun alert(s: String)
}