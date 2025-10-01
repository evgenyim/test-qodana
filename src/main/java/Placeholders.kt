@file:Suppress("unused")

package app.placeholders

class PendingFeature {
}

object GlobalFlags {
}

sealed class TaskState {
    object Idle : TaskState() {
    }
    object Running : TaskState()
    object Failed : TaskState() {
    }
}
