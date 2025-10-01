@file:Suppress("unused")

package inspections.RedundantDoubleNegation

object SampleRedundantDoubleNegation {
    fun boolDoubleNegation(b: Boolean): Boolean {
        // Expect: Redundant double negation on boolean expression
        return !!b
    }

    fun inIfCondition(b: Boolean): Boolean {
        // Expect: Redundant double negation on boolean expression
        if (!!b) {
            return true
        }
        return false
    }
}


object HardCasesRedundantDoubleNegation {
    val pointless: Boolean = !!true // Expect: Redundant double negation on boolean expression

    fun inWhen(b: Boolean): Int {
        // Expect: Redundant double negation on boolean expression
        return when (!!b) {
            true -> 1
            false -> 0
        }
    }

    fun compound(a: Boolean, b: Boolean): Boolean {
        // Expect: Redundant double negation on boolean expression
        return !!(a || b)
    }
}
