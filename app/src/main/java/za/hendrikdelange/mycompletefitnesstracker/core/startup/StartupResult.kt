package za.hendrikdelange.mycompletefitnesstracker.core.startup

sealed class StartupResult {

    data object GoToHome : StartupResult()

    data object GoToLogin : StartupResult()

    data object GoToProfileSetup : StartupResult()

    data class Error(
        val message: String
    ) : StartupResult()

}