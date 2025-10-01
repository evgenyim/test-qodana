@file:Suppress("unused")

package app.monolith

import java.math.BigDecimal

interface PricingEngine {
    fun quote(sku: String, qty: Int, priority: Boolean): Money
}

interface Inventory {
    fun hasStock(sku: String, qty: Int): Boolean
    fun reserve(sku: String, qty: Int): Boolean
    fun release(sku: String, qty: Int)
}

interface Payments {
    fun charge(amount: BigDecimal, token: String): Boolean
    fun fetchPaymentMeta(customerId: String): Any
}

interface EventBus {
    fun publish(event: OrderPlaced)
}
