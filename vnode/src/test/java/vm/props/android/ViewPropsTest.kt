package vm.props.android

import org.junit.Test

import org.junit.Assert.*

class ViewPropsTest {
    @Test
    fun getId() {
        val vp = ViewProps {
            id = 2
            layoutParams = RelativeLayoutParams()
        }
        assert(vp.layoutParams is RelativeLayoutParams)
    }
}
