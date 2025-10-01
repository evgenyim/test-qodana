@file:Suppress("unused")

package app.billing

import app.monolith.Money
import java.math.BigDecimal

object DisabledBilling {}

class PlaceholderGateway {}

class FixedRateGateway(private val rate: BigDecimal) {
    fun charge(amount: Money, token: String): Boolean {
        if (token.isBlank()) return false
        val final = amount.amount.multiply(rate)
        return final >= BigDecimal.ZERO
    }
}
