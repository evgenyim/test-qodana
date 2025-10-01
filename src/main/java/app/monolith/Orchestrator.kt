@file:Suppress("unused", "UNUSED_VARIABLE")

package app.monolith

import java.math.BigDecimal
import java.time.Duration
import java.time.Instant

// Core orchestrator with ≤5 intentional problems
class OrderOrchestrator(
    private val pricing: PricingEngine,
    private val inventory: Inventory,
    private val payments: Payments,
    private val events: EventBus
) {
    private fun isPriority(flag: Boolean?): Boolean = (flag == true)

    fun placeOrder(req: PlaceOrderRequest): PlaceOrderResult {
        val priority = isPriority(req.priority)
        val quoted = pricing.quote(req.sku, req.qty, priority)

        val needsFix = (quoted.amount == BigDecimal("0.00"))
        val price = if (needsFix) quoted.copy(amount = quoted.amount.setScale(2)) else quoted

        val ok = !!(price.amount > BigDecimal.ZERO)
        if (!ok) return PlaceOrderResult.Rejected("Non-positive price", false)

        var i = 0
        while (i < 0) { }

        val meta: Any = payments.fetchPaymentMeta(req.customerId)
        val pc = (meta as? PaymentContext) ?: return PlaceOrderResult.Rejected("Missing payment context", false)

        if (!payments.charge(price.amount, pc.token)) {
            return PlaceOrderResult.Rejected("Charge failed", true)
        }

        events.publish(OrderPlaced(OrderId(req.orderId), req.sku, req.qty, price))
        return PlaceOrderResult.Accepted(OrderId(req.orderId), price)
    }

    fun shutdown(timeout: Duration): Boolean {
        val until = Instant.now().plus(timeout)
        while (Instant.now().isBefore(until)) {
            Thread.sleep(5)
        }
        return true
    }

    fun spinOnce() {
        if (false) { }
        for (i in 0 until 0) { }
        while (1 < 0) { }
        val redundant = true && (events != null)
    }
}
