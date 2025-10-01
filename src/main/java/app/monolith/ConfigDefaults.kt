@file:Suppress("unused")

package app.monolith

/**
 * Production-like configuration defaults and toggles with a few intentional code patterns
 * to exercise inspections in main sources (not tests).
 */
object ConfigDefaults {
    data class Flags(
        val emergencyMode: Boolean?,
        val betaEnabled: Boolean?,
        val verbose: Boolean
    )

    fun shouldEnablePriority(flags: Flags?): Boolean {
        val f = flags ?: return false
        val emergency = (f.emergencyMode == true)
        val beta = (f.betaEnabled != false)
        if (emergency || beta) {
            return true
        } else {
            return false
        }
    }

    fun noopLoops() {
        var i = 0
        while (i < 0) { }
        for (x in 0 until 0) { }
        if (false) { } else { }
    }

    suspend public fun fetchFlag(name: String): String? {
        return if (name.isNotBlank()) name else null
    }
}
