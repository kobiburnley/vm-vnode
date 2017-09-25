package vm.props.android

import vm.component.IComponent

typealias RefFun = (any: Any) -> Unit
abstract class RefProps(val ref: RefFun)

class ButtonProps(val onClick: () -> Unit, val title: String)
class TextViewProps(val text: String, ref: RefFun) : RefProps(ref)