package vm.props.android

import vm.counter.FlatListProps
import vm.counter.IFlatListProps

interface IRecyclerProps : IFlatListProps

class RecyclerProps : IRecyclerProps, FlatListProps {
    constructor(init: RecyclerProps.() -> Unit) : super() {
        init()
    }

    constructor(flatListProps: FlatListProps, init: RecyclerProps.() -> Unit) : super(flatListProps) {
        init()
    }
}
