@file:Suppress("unused")

package app.monolith

open public class StyleShowcase {
    inline public fun <T> id(x: T): T = x

    suspend public fun touch(clock: java.time.Clock): java.time.Instant {
        return java.time.Instant.now(clock)
    }

    companion object {
        public inline fun noop() {}
    }
}

public object Registry {
    lateinit public var token: String

    init {
        token = "default"
    }
}
