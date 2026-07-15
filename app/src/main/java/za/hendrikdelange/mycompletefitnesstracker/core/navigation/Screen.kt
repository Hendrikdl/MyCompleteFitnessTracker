package za.hendrikdelange.mycompletefitnesstracker.core.navigation


sealed class Screen(
    val route: String
) {


    object Splash : Screen("splash")


    object Login : Screen("login")


    object Register : Screen("register")


    object ProfileCheck : Screen("profile_check")


    object ProfileSetup : Screen("profile_setup")


    object Dashboard : Screen("dashboard")


}