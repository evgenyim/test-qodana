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


object HardCasesBigDecimalEquality {
    fun whenCompare(a: BigDecimal, b: BigDecimal): Int {
        // Expect: BigDecimal values should be compared using compareTo() instead of ==
        return when {
            a == b -> 0
            a != b -> 1 // Expect as well
            else -> 2
        }
    }

    fun listContainsEq(list: List<BigDecimal>, x: BigDecimal): Boolean {
        // Expect: BigDecimal values should be compared using compareTo() instead of ==
        return list.isNotEmpty() && (list[0] == x)
    }

    fun equalsInMapKey(map: Map<BigDecimal, String>, key: BigDecimal): Boolean {
        // Expect: BigDecimal values should be compared using compareTo() instead of equals()
        return map.keys.firstOrNull()?.equals(key) == true
    }
}
