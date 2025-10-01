@file:Suppress("unused")

package app.billing

import java.math.BigDecimal

interface TaxCalculator {
    fun calculateTax(amount: BigDecimal, promoActive: Boolean): BigDecimal
}

interface PaymentGateway {
    fun charge(amount: BigDecimal, token: String): Boolean
    fun fetchMeta(cartId: String): Any
}

data class Promotion(val code: String, val enabled: Boolean?, val discountValue: BigDecimal)
