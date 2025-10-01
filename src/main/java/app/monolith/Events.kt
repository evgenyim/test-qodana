@file:Suppress("unused")

package app.monolith

import java.time.Instant

// Non-conflicting supplemental event type; core order types are declared in Models.kt

data class AuditLogEntry(
    val at: Instant,
    val category: String,
    val message: String,
)
