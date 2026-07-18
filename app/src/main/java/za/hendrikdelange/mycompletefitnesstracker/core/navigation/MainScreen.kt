package za.hendrikdelange.mycompletefitnesstracker.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import za.hendrikdelange.mycompletefitnesstracker.ui.exercises.ExerciseScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.home.HomeScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.profile.ProfileScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.progress.ProgressScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.workouts.WorkoutDetailScreen
import za.hendrikdelange.mycompletefitnesstracker.ui.workouts.WorkoutScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()

    Scaffold(

        bottomBar = {

            BottomBar(navController)

        }

    ) { innerPadding ->

        NavHost(

            navController = navController,

            startDestination = NavigationItem.Home.route,

            modifier = Modifier.padding(innerPadding)

        ) {

            composable(
                NavigationItem.Home.route
            ) {

                HomeScreen()

            }

            composable(
                NavigationItem.Exercises.route
            ) {

                ExerciseScreen()

            }

            composable(
                NavigationItem.Workouts.route
            ) {

                WorkoutScreen(
                    onWorkoutClick = {workoutId ->
                        navController.navigate(
                            Screen.WorkoutDetail.createRoute(workoutId)
                        )
                    }
                )

            }

            composable(

                route = Screen.WorkoutDetail.route

            ) { backStackEntry ->

                val workoutId = backStackEntry.arguments
                    ?.getString("workoutId")
                    ?.toLongOrNull() ?: 0L

                WorkoutDetailScreen(

                    workoutId = workoutId

                )

            }

            composable(
                "workoutDetail/{workoutId}"
            ) { backStackEntry ->

                val workoutId =
                    backStackEntry.arguments
                        ?.getString("workoutId")
                        ?.toLongOrNull() ?: 0L

                WorkoutDetailScreen(
                    workoutId = workoutId
                )

            }

            composable(
                NavigationItem.Progress.route
            ) {

                ProgressScreen()

            }

            composable(
                NavigationItem.Profile.route
            ) {

                ProfileScreen()

            }

        }

    }

}