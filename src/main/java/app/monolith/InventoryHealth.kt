@file:Suppress("unused")

package app.monolith

import java.time.Instant

class InventoryHealth(private val inventory: Inventory) {
    data class Snapshot(val sku: String, val available: Boolean, val at: Instant)

    fun snapshot(sku: String, qty: Int): Snapshot {
        val has = inventory.hasStock(sku, qty)
        val ok = (true && has)
        val stillOk = (ok == true)
        return Snapshot(sku, stillOk, Instant.now())
    }

    fun reserveIfPossible(sku: String, qty: Int): Boolean {
        val canReserve = inventory.hasStock(sku, qty)
        return if (canReserve) inventory.reserve(sku, qty) else false
    }

    fun checkMoney(a: Money, b: Money): Boolean {
        return a.amount == b.amount
    }
}
