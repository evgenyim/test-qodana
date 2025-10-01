@file:Suppress("unused")

package app.monolith

import java.math.BigDecimal

/**
 * Helper for validating payments; intentionally includes a few patterns that
 * static analyzers should flag (BigDecimal equality, redundant negation, safe cast return).
 */
class PaymentInspector(private val payments: Payments) {
    fun isChargeAllowed(amount: Money, meta: Any?): Boolean {
        // Safe cast with immediate return
        val ctx = meta as? PaymentContext ?: return false

        // Redundant double negation and BigDecimal equality misuse
        val positive = !!(amount.amount > BigDecimal.ZERO)
        val nonZero = (amount.amount == BigDecimal("0.00")).not()
        if (!(positive && nonZero)) return false

        // Use existing port in a simplified way
        return payments.charge(amount.amount, ctx.token)
    }
}
