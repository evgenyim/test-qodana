@file:Suppress("unused")

package inspections.EmptyControlFlowBody

object SampleEmptyControlFlowBody {
    fun demo(cond: Boolean, list: List<Int>) {
        // Expect: Empty if body and empty else body
        if (cond) {
        } else {
        }

        // Expect: Empty while body
        var i = 0
        while (i < 3) {
        }

        // Expect: Empty do-while body
        do {
        } while (i < 0)

        // Expect: Empty for body
        for (x in list) {
        }
    }
}
