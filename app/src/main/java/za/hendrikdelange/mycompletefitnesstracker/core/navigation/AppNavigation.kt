package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.hendrikdelange.mycompletefitnesstracker.ui.auth.LoginScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.auth.RegisterScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.profile.ProfileCheckScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.profile.ProfileSetupScreen
import com.google.firebase.auth.FirebaseAuth
import za.hendrikdelange.mycompletefitnesstracker.core.startup.SplashScreen
import za.hendrikdelange.mycompletefitnesstracker.core.navigation.MainScreen
import za.hendrikdelange.mycompletefitnesstracker.core.startup.StartupResult
import za.hendrikdelange.mycompletefitnesstracker.ui.exercises.ExerciseDetailsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()


    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {



        composable(Screen.ProfileCheck.route) {

            val uid = FirebaseAuth.getInstance().currentUser?.uid

            if (uid != null) {

                ProfileCheckScreen(

                    uid = uid,

                    onProfileFound = {

                        navController.navigate(Screen.Dashboard.route) {
                            popUpTo(Screen.ProfileCheck.route) {
                                inclusive = true
                            }
                        }

                    },

                    onProfileMissing = {

                        navController.navigate(Screen.ProfileSetup.route) {
                            popUpTo(Screen.ProfileCheck.route) {
                                inclusive = true
                            }
                        }

                    }

                )

            } else {

                Text("No authenticated user")

            }

        }

        composable(Screen.ProfileSetup.route) {

            val uid = FirebaseAuth.getInstance().currentUser?.uid

            if (uid != null) {

                ProfileSetupScreen(

                    firebaseUid = uid,

                    onComplete = {

                        navController.navigate(Screen.Dashboard.route) {

                            popUpTo(Screen.ProfileSetup.route) {
                                inclusive = true
                            }

                        }

                    }

                )

            } else {

                Text("No authenticated user")

            }

        }

        composable(Screen.Splash.route) {

            SplashScreen(

                onFinished = { result ->

                    when (result) {

                        StartupResult.GoToLogin -> {

                            navController.navigate(
                                Screen.Login.route
                            ) {

                                popUpTo(Screen.Splash.route) {
                                    inclusive = true
                                }

                            }

                        }

                        StartupResult.GoToProfileCheck -> {

                            navController.navigate(
                                Screen.ProfileCheck.route
                            ) {

                                popUpTo(Screen.Splash.route) {
                                    inclusive = true
                                }

                            }

                        }

                        is StartupResult.Error -> {

                            // We'll improve this later.
                            // For now just send the user to Login.

                            navController.navigate(
                                Screen.Login.route
                            ) {

                                popUpTo(Screen.Splash.route) {
                                    inclusive = true
                                }

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
                        Screen.Splash.route
                    ) {

                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }

                    }

                },

                onRegisterClick = {

                    navController.navigate(
                        Screen.Register.route
                    )

                }

            )

        }

        composable(Screen.Register.route) {

            RegisterScreen(

                onRegistered = {

                    navController.navigate(Screen.ProfileCheck.route)

                }

            )

        }


        composable(Screen.Dashboard.route) {
            MainScreen()
        }

    }

}