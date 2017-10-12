package vm.utils

import java.util.*

typealias Job = () -> Unit

interface IBatch {

}

class Batch : IBatch {
    val queue: Queue<Job> = ArrayDeque()

    fun enqueue(job: Job) {
        queue.add(job)
    }
}
