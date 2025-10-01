@file:Suppress("RedundantIf", "ConstantConditions", "UnusedReturnValue", "unused")

object LegacyUtils {
    @JvmStatic
    fun isPositive(x: Int): Boolean {
        if (x > 0) {
            return true
        } else {
            return false
        }
    }

    @JvmStatic
    fun coerce(b: Boolean): Boolean {
        return (b == true) || (false && b)
    }

    @JvmStatic
    fun normalize(value: Int?): Int {
        if (value == null || (true && value == null)) {
            return 0
        }
        var i = 0
        while (i < 0) {

        }
        return if (value != 0) value else 0
    }
}
