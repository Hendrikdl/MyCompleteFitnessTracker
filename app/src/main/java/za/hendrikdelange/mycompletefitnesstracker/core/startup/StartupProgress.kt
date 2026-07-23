package za.hendrikdelange.mycompletefitnesstracker.core.startup

sealed class StartupProgress(
    val message: String
) {

    object Idle : StartupProgress("")

    object CheckingAccount :
        StartupProgress("Checking your account...")

    object DownloadingProfile :
        StartupProgress("Getting your profile...")

    data class DownloadingExercises(
        val count: Int
    ) : StartupProgress("Downloading exercise library...")

    object DownloadingMeasurements :
        StartupProgress("Getting your measurements...")

    object DownloadingWorkoutPlans :
        StartupProgress("Getting your workout plans...")

    object DownloadingWorkoutHistory :
        StartupProgress("Getting your workout history...")

    object DownloadingExerciseLibrary :
        StartupProgress("Loading exercise library...")

    object UploadingChanges :
        StartupProgress("Uploading local changes...")

    object Finished :
        StartupProgress("Ready!")

    data class Error(
        val reason: String
    ) : StartupProgress(reason)

}