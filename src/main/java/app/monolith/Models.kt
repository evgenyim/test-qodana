@file:Suppress("unused")

package app.monolith

import java.math.BigDecimal
import java.time.Instant

data class OrderId(val raw: String)

data class Money(val amount: BigDecimal, val currency: String) {
    override fun toString(): String = "$currency $amount"
}

data class PlaceOrderRequest(
    val orderId: String,
    val customerId: String,
    val sku: String,
    val qty: Int,
    val priority: Boolean?
)

sealed class PlaceOrderResult {
    data class Accepted(val id: OrderId, val price: Money) : PlaceOrderResult()
    data class Rejected(val reason: String, val suggestedRetry: Boolean) : PlaceOrderResult()
}

data class OrderPlaced(
    val id: OrderId,
    val sku: String,
    val qty: Int,
    val price: Money
)

data class SettlementLine(val reference: String, val success: Boolean)

data class LastOrder(val instant: Instant, val price: Money)

data class Customer(val id: String, val vip: Boolean)

data class PaymentContext(val token: String, val enabled: Boolean?)
