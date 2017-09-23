package vm.component

interface ILifeCycle<P> {
    fun componentDidMount()
    fun componentWillMount()
    fun componentWillReceiveProps(newProps: P)
}