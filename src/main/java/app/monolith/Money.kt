@file:Suppress("unused")

package app.monolith

import java.math.BigDecimal

fun Money.isPositive(): Boolean = this.amount > BigDecimal.ZERO

fun Money.add(other: Money): Money {
    require(this.currency == other.currency) { "Currency mismatch: ${this.currency} vs ${other.currency}" }
    return Money(this.amount + other.amount, this.currency)
}
