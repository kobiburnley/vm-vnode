package vm.render.measue

var density: Float = 1F

val Int.dp: Int
    get() = (this * density).toInt()

//fun Int.dp(): Int = 10