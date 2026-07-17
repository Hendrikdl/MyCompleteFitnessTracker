package za.hendrikdelange.mycompletefitnesstracker.data.model

enum class WorkoutCategory(
    val displayName: String
) {

    PUSH("Push"),
    PULL("Pull"),
    LEGS("Legs"),
    UPPER("Upper"),
    LOWER("Lower"),
    FULL_BODY("Full Body"),
    CARDIO("Cardio"),
    CORE("Core"),
    MOBILITY("Mobility"),
    RECOVERY("Recovery")

}