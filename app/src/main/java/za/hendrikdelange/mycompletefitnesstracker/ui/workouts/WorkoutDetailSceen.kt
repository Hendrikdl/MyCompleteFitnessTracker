package za.hendrikdelange.mycompletefitnesstracker.ui.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import za.hendrikdelange.mycompletefitnesstracker.core.navigation.Screen
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.WorkoutHeader
import za.hendrikdelange.mycompletefitnesstracker.ui.exercises.ExerciseCard
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.WorkoutViewModel
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutDetailScreen(

    workoutId: Long,

    navController: NavHostController,

    viewModel: WorkoutViewModel = hiltViewModel()

) {

    val workout by viewModel
        .getWorkout(workoutId)
        .collectAsState(initial = null)

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(

                        text = workout?.category ?: "Workout",

                        color = FitnessDesign.colors.TextPrimary

                    )

                },

                navigationIcon = {

                    IconButton(

                        onClick = {

                            navController.popBackStack()

                        }

                    ) {

                        Icon(

                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,

                            contentDescription = "Back",

                            tint = FitnessDesign.colors.Primary

                        )

                    }

                },

                colors = TopAppBarDefaults.topAppBarColors(

                    containerColor = FitnessDesign.colors.Background

                )

            )

        },

        containerColor = FitnessDesign.colors.Background,

        floatingActionButton = {

            FloatingActionButton(

                onClick = {

                    navController.navigate(
                        Screen.ExercisePicker.createRoute(workoutId)
                    )

                },

                containerColor = FitnessDesign.colors.Primary

            ) {

                Icon(

                    imageVector = Icons.Default.Add,

                    contentDescription = "Add Exercise"

                )

            }

        }

    ) { padding ->
            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .background(FitnessDesign.colors.Background)
                    .padding(padding)
                    .padding(FitnessDesign.spacing.Medium),

                verticalArrangement = Arrangement.spacedBy(
                    FitnessDesign.spacing.Medium
                )

            ) {

                workout?.let {

                    WorkoutHeader(
                        workout = it
                    )

                }

                Text(

                    text = "Exercises",

                    style = FitnessDesign.typography.TitleMedium,

                    color = FitnessDesign.colors.TextPrimary

                )

                val exercises by viewModel
                    .getExercisesForWorkout(workoutId)
                    .collectAsState(initial = emptyList())

                LazyColumn(

                    verticalArrangement = Arrangement.spacedBy(
                        FitnessDesign.spacing.Small
                    )

                ) {

                    items(exercises) { item ->

                        ExerciseCard(

                            exercise = item.exercise

                        )

                        if (!item.workoutExercise.isConfigured) {

                            Text("⚠ Setup Required")

                        }
                        else {

                            Text(
                                "${item.workoutExercise.sets} Sets • " +
                                        "${item.workoutExercise.repsFrom}-${item.workoutExercise.repsTo} Reps"
                            )

                        }

                    }

                }

            }

        }

    }