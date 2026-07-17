package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.FitnessCenter
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ShowChart
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(

    val route: String,

    val title: String,

    val icon: ImageVector

) {

    object Home : NavigationItem(
        "home",
        "Home",
        Icons.Rounded.Home
    )

    object Exercises : NavigationItem(
        "exercises",
        "Exercises",
        Icons.Rounded.FitnessCenter
    )

    object Workouts : NavigationItem(
        "workouts",
        "Workouts",
        Icons.Rounded.AddCircle
    )

    object Progress : NavigationItem(
        "progress",
        "Progress",
        Icons.Rounded.ShowChart
    )

    object Profile : NavigationItem(
        "profile",
        "Profile",
        Icons.Rounded.Person
    )

}