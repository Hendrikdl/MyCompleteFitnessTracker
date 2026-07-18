package za.hendrikdelange.mycompletefitnesstracker.ui.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.WorkoutCard
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.WorkoutViewModel
import androidx.compose.runtime.setValue
import za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs.CreateWorkoutPlanDialog
import androidx.navigation.NavHostController


@Composable
fun WorkoutScreen(

    onWorkoutClick: (Long) -> Unit,

    viewModel: WorkoutViewModel = hiltViewModel()

)  {

    val workouts by viewModel.workouts.collectAsState()
    var showCreateDialog by remember {
        mutableStateOf(false)
    }

    androidx.compose.material3.Scaffold(

        containerColor = FitnessDesign.colors.Background,

        floatingActionButton = {

            FloatingActionButton(

                onClick = {

                    showCreateDialog = true

                },

                containerColor = FitnessDesign.colors.Primary

            ) {

                Icon(

                    imageVector = Icons.Default.Add,

                    contentDescription = "Create Plan"

                )

            }

        }

    ) { padding ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(FitnessDesign.colors.Background)
                .padding(padding)
                .padding(FitnessDesign.spacing.Medium),

            verticalArrangement = Arrangement.spacedBy(
                FitnessDesign.spacing.Small
            )

        ) {

            items(workouts) { workout ->

                WorkoutCard(

                    workout = workout,

                    onClick = {

                      onWorkoutClick(workout.id)

                    }
                )

            }

        }
        if (showCreateDialog) {

            CreateWorkoutPlanDialog(

                onDismiss = {

                    showCreateDialog = false

                },

                onSave = { name, category, dayOfWeek ->

                    viewModel.createWorkout(

                        name = name,
                        category = category,
                        dayOfWeek = dayOfWeek


                    )

                    showCreateDialog = false

                }

            )

        }

    }



}