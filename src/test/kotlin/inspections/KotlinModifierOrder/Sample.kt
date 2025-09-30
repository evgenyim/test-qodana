@file:Suppress("unused")

package inspections.KotlinModifierOrder

// Expect: Modifiers are not in the recommended order ("suspend" should come after visibility)
suspend public fun badOrderFunction() {}

// Multiple modifiers in wrong order
inline public fun badOrderInline() {}

class Holder {
    // Wrong order inside class as well
    tailrec private fun badOrderMethod(n: Int): Int {
        return if (n <= 1) 1 else badOrderMethod(n - 1)
    }
}
