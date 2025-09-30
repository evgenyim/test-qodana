@file:Suppress("unused", "UNUSED_VARIABLE")

package inspections.BooleanExpressionCanBeReduced

object SampleBooleanReduction {
    fun eqWithTrue(x: Boolean): Boolean {
        // Expect: Expression can be reduced to 'x'
        return x == true
    }

    fun eqWithFalse(y: Boolean): Boolean {
        // Expect: Expression can be reduced to '!y'
        return y == false
    }

    fun notEqWithTrue(z: Boolean): Boolean {
        // Expect: Expression can be reduced to '!z'
        return z != true
    }

    fun notEqWithFalse(a: Boolean): Boolean {
        // Expect: Expression can be reduced to 'a'
        return a != false
    }

    fun andWithTrue(b: Boolean): Boolean {
        // Expect: Expression can be reduced to 'b'
        val a = b && false
        return true && b
    }

    fun andWithFalse(c: Boolean): Boolean {
        // Expect: Expression can be reduced to 'false'
        return c && false
    }

    fun orWithTrue(d: Boolean): Boolean {
        // Expect: Expression can be reduced to 'true'
        return d || true
    }

    fun orWithFalse(e: Boolean): Boolean {
        // Expect: Expression can be reduced to 'e'
        return false || e
    }
}
