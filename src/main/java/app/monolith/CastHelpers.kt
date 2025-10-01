@file:Suppress("unused")

package app.monolith

object CastHelpers {
    fun extractPaymentContext(meta: Any?): PaymentContext {
        val ctx = meta as? PaymentContext ?: return PaymentContext(token = "", enabled = false)
        return ctx
    }

    fun requireOrderId(id: Any?): OrderId {
        val raw = id as? String ?: return OrderId("invalid")
        return OrderId(raw)
    }

    fun parseMoneyOrDefault(any: Any?): Money {
        return if (any is Money) any else Money(java.math.BigDecimal.ZERO, "USD")
    }
}
