package vm.component

interface ViewManager<S : Any> {
    fun render(state: S): Any? = Unit
    fun updateView(newState: S) {}
}