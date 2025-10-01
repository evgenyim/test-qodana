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


// Additional hard cases for modifier order
const public val wrongConstOrder: Int = 1 // Expect: Modifiers are not in the recommended order. Expected: public const

class MoreHolder {
    lateinit private var badField: String // Expect: Modifiers are not in the recommended order. Expected: private lateinit

    // Combination with annotations and multiple modifiers
    @Suppress("NOTHING_TO_INLINE")
    tailrec inline public fun combo(n: Int): Int { // Expect: Modifiers are not in the recommended order. Expected: public inline tailrec
        return if (n <= 1) 1 else combo(n - 1)
    }
}

data public class WrongDataOrder(val x: Int) // Expect: Modifiers are not in the recommended order. Expected: public data
