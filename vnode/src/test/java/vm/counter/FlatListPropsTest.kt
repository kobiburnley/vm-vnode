package vm.counter

import org.junit.Test

import org.junit.Assert.*
import vm.props.android.RelativeLayoutParams
import vm.props.android.ViewProps

/**
 * Created by kobi on 10/10/17.
 */
class FlatListPropsTest {
    @Test
    fun init() {
        val props = FlatListProps {
            layoutParams = RelativeLayoutParams(below = 10)
        }
        assert(props.layoutParams is RelativeLayoutParams)
    }

}