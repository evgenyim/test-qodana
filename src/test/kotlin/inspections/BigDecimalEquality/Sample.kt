@file:Suppress("unused")

package inspections.BigDecimalEquality

import java.math.BigDecimal

object SampleBigDecimalEquality {
    fun eqOperator(a: BigDecimal, b: BigDecimal): Boolean {
        // Expect: BigDecimal values should be compared using compareTo() instead of ==
        return a == b
    }

    fun notEqOperator(a: BigDecimal, b: BigDecimal): Boolean {
        // Expect: BigDecimal values should be compared using compareTo() instead of !=
        return a != b
    }

    fun equalsCall(a: BigDecimal, b: BigDecimal): Boolean {
        // Expect: BigDecimal values should be compared using compareTo() instead of equals()
        return a.equals(b)
    }

    fun notEqualsCall(a: BigDecimal, b: BigDecimal): Boolean {
        // Expect: BigDecimal values should be compared using compareTo() instead of !equals()
        return !a.equals(b)
    }
}
