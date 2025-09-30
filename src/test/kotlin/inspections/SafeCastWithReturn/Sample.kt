@file:Suppress("unused")

package inspections.SafeCastWithReturn

object SampleSafeCastWithReturn {
    fun takeString(x: Any?) {
        // Expect: Safe cast expression with return can be replaced with type check using 'if' statement
        x as? String ?: return
        // After this point, x is smart-cast to String only if we re-cast; this is just for sample
        val len = (x as String).length
        println(len)
    }

    fun takeStringHard(x: Any?) {
        // Parentheses variant should also be caught
        (x as? String) ?: return
        println((x as String).length)
    }
}
