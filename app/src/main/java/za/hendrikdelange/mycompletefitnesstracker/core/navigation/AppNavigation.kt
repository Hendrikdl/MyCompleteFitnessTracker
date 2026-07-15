package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.hendrikdelange.mycompletefitnesstracker.ui.auth.LoginScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.auth.RegisterScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.dashboard.DashboardScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.splash.SplashScreen


@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {

        composable(Screen.Splash.route) {
            SplashScreen()
        }

        composable(Screen.Login.route) {
            LoginScreen()
        }

        composable(Screen.Register.route) {
            RegisterScreen()
        }

        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }

    }

}