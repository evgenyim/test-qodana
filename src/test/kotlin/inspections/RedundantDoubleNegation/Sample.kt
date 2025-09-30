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
