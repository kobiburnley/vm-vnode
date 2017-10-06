package vm.component

interface ILifeCycle<P> {
    fun componentWillUnmount()
    fun componentDidMount()
    fun componentWillMount()
    fun componentWillReceiveProps(newProps: P)
}