@file:Suppress("unused")

package app.misorder

import java.time.Instant

suspend public fun fetchNow(): Instant = Instant.now()

inline public fun <T> measure(block: () -> T): T {
    val start = System.nanoTime()
    try {
        return block()
    } finally {
        val elapsed = System.nanoTime() - start
        if (elapsed > 0) {
            // pretend to log
        }
    }
}

class ModifierOrderHolder {
    tailrec private fun factorial(n: Int, acc: Long = 1): Long = if (n <= 1) acc else factorial(n - 1, acc * n)

    inner public class Inner(val name: String)

    companion object {
        lateinit public var INSTANCE: ModifierOrderHolder
    }
}
