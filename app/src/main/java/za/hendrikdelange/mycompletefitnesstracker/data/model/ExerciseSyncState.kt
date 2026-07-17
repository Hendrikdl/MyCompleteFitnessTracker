package za.hendrikdelange.mycompletefitnesstracker.data.model

sealed class ExerciseSyncState {

    object Idle : ExerciseSyncState()

    object Checking : ExerciseSyncState()

    data class Downloading(
        val downloaded: Int
    ) : ExerciseSyncState()

    data class Complete(
        val count: Int
    ) : ExerciseSyncState()

    data class Error(
        val message: String
    ) : ExerciseSyncState()

}