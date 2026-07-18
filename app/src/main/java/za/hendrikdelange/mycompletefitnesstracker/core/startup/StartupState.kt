package za.hendrikdelange.mycompletefitnesstracker.core.startup

enum class StartupStep {

    INITIALIZING,

    CHECKING_AUTH,

    LOADING_PROFILE,

    LOADING_EXERCISES,

    SYNCING,

    COMPLETE,

    ERROR

}

data class StartupState(

    val step: StartupStep = StartupStep.INITIALIZING,

    val message: String = "Initializing...",

    val progress: Float = 0f

)