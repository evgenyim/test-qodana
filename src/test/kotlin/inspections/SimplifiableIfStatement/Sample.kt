@file:Suppress("unused")

package inspections.SimplifiableIfStatement

object SampleSimplifiableIf {
    fun returnInBothBranches(cond: Boolean): Boolean {
        // Expect: If statement can be simplified to 'return condition'
        if (cond) {
            return true
        } else {
            return false
        }
    }

    fun returnThenFollowedByReturn(cond: Boolean): Boolean {
        // Expect: If statement can be simplified to 'return !condition'
        if (cond) {
            return false
        }
        return true
    }

    fun expressionBranches(cond: Boolean): Boolean {
        // Expect: If expression can be simplified to 'condition'
        return if (cond) true else false
    }
}


object HardCasesSimplifiableIf {
    fun sameReturnValue(cond: Boolean, v: Int): Int {
        // Expect: If statement can be simplified to 'return v'
        if (cond) {
            return v
        } else {
            return v
        }
    }

    fun earlyReturn(cond: Boolean): Boolean {
        // Expect: If statement can be simplified to 'return cond'
        if (cond) return true else return false
    }

    fun negated(cond: Boolean): Boolean {
        // Expect: If statement can be simplified to 'return !cond'
        if (!cond) {
            return true
        } else {
            return false
        }
    }
}
