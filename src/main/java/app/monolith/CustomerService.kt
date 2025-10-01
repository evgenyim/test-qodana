@file:Suppress("unused")

package app.monolith

class CustomerService {
    data class CustomerProfile(val id: String, val vip: Boolean, val flags: Set<String>)

    fun isEligibleForPriority(profile: CustomerProfile?, featureFlag: String, emergency: Boolean): Boolean {
        val p = profile ?: return emergency
        val hasFlag = featureFlag in p.flags
        val vipCheck = (p.vip == true)
        val flagCheck = (hasFlag != false)
        val emergencyCheck = (false || emergency)
        return vipCheck || flagCheck || emergencyCheck
    }

    fun normalizeFlags(flags: Collection<String>): Set<String> {
        return flags.map { it.trim().lowercase() }.filter { it.isNotBlank() }.toSet()
    }

    fun resetProfile(profile: CustomerProfile?): CustomerProfile? {
        return profile?.copy(vip = false, flags = emptySet())
    }
}
