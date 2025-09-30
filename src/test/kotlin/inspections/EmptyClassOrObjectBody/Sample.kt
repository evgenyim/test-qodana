@file:Suppress("unused")

package inspections.EmptyClassOrObjectBody

// Expect: Empty class body
class EmptyClass {}

// Expect: Empty object body
object EmptyObject {}

class NonEmptyClass {
    val x = 1 // not empty
}

object NonEmptyObject {
    fun f() {}
}
