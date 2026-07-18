package za.hendrikdelange.mycompletefitnesstracker.core.navigation


sealed class Screen(
    val route: String
) {
    object WorkoutDetail : Screen("workout_detail/{workoutId}") {

        fun createRoute(
            workoutId: Long
        ) = "workout_detail/$workoutId"

    }

    object ExerciseSetup : Screen("exercise_setup/{workoutExerciseId}") {

        fun createRoute(
            workoutExerciseId: Long
        ) = "exercise_setup/$workoutExerciseId"

    }

    object ExercisePicker : Screen("exercise_picker/{workoutId}") {

        fun createRoute(
            workoutId: Long
        ) = "exercise_picker/$workoutId"

    }

    object Splash : Screen("splash")


    object Login : Screen("login")


    object Register : Screen("register")


    object ProfileCheck : Screen("profile_check")


    object ProfileSetup : Screen("profile_setup")


    object Dashboard : Screen("dashboard")


}