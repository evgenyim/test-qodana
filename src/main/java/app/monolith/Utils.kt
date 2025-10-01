@file:Suppress("unused")

package app.monolith

import java.time.Instant

suspend public fun fetchClockNow(): Instant = Instant.now()

inline public fun <T> timed(name: String, block: () -> T): T {
    val start = System.nanoTime()
    try {
        return block()
    } finally {
        val elapsed = System.nanoTime() - start
        if (elapsed > 0) {
        }
    }
}
