package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.hendrikdelange.mycompletefitnesstracker.ui.auth.LoginScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.auth.RegisterScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.dashboard.DashboardScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.splash.SplashScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.profile.ProfileCheckScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.profile.ProfileSetupScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.AuthViewModel


@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()

    val currentUserUid by authViewModel.currentUserUid.collectAsState()

    LaunchedEffect(Unit) {

        authViewModel.loadCurrentUser()

    }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {



        composable(Screen.ProfileCheck.route) {

            currentUserUid?.let { uid ->

                ProfileCheckScreen(

                    uid = uid,

                    onProfileFound = {

                        navController.navigate(
                            Screen.Dashboard.route
                        )

                    },

                    onProfileMissing = {

                        navController.navigate(
                            Screen.ProfileSetup.route
                        )

                    }

                )

            }

        }

        composable(Screen.ProfileSetup.route) {

            currentUserUid?.let { uid ->

                ProfileSetupScreen(

                    firebaseUid = uid,

                    onComplete = {

                        navController.navigate(
                            Screen.Dashboard.route
                        ) {

                            popUpTo(
                                Screen.ProfileSetup.route
                            ) {
                                inclusive = true
                            }

                        }

                    }

                )

            }

        }

        composable(Screen.Splash.route) {

            SplashScreen(

                onFinished = { loggedIn ->

                    if (loggedIn) {

                        navController.navigate(
                            Screen.ProfileCheck.route
                        ) {

                            popUpTo(
                                Screen.Splash.route
                            ) {
                                inclusive = true
                            }

                        }

                    } else {

                        navController.navigate(
                            Screen.Login.route
                        ) {

                            popUpTo(
                                Screen.Splash.route
                            ) {
                                inclusive = true
                            }

                        }

                    }

                }

            )

        }

        composable(Screen.Login.route) {

            LoginScreen(

                onLoginSuccess = {

                    navController.navigate(
                        Screen.ProfileCheck.route
                    )

                },

                onRegisterClick = {

                    navController.navigate(
                        Screen.ProfileCheck.route
                    )

                }

            )

        }

        composable(Screen.Register.route) {

            RegisterScreen(
                onRegistered = {

                    navController.navigate(
                        Screen.Dashboard.route
                    )

                }
            )

        }

        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }

    }

}