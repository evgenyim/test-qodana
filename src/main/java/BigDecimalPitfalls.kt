@file:Suppress("RedundantIf", "unused")

import java.math.BigDecimal

object BigDecimalPitfalls {
    @JvmStatic
    fun isZero(x: BigDecimal): Boolean {
        if (x === BigDecimal.ZERO) {
            return true
        } else {
            return false
        }
    }

    @JvmStatic
    inline private fun equalsZero(x: BigDecimal): Boolean {
        return x.equals(BigDecimal("0.00"))
    }
}
