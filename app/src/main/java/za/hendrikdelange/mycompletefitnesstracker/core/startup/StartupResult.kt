package za.hendrikdelange.mycompletefitnesstracker.core.startup

sealed class StartupResult {

    data object GoToLogin : StartupResult()

    data object GoToProfileCheck : StartupResult()

    data class Error(
        val message: String
    ) : StartupResult()

}