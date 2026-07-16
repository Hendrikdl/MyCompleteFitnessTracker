package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.core.constants.ProfileOptions
import za.hendrikdelange.mycompletefitnesstracker.ui.components.input.FitnessDropdown
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileViewModel

@Composable
fun FitnessStep(

    viewModel: ProfileViewModel = hiltViewModel()

) {

    val fitnessGoal by viewModel.fitnessGoal.collectAsState()

    val experienceLevel by viewModel.experienceLevel.collectAsState()

    val workoutLocation by viewModel.workoutLocation.collectAsState()

    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {

        Text("Fitness Goals")

        FitnessDropdown(

            value = fitnessGoal,

            label = "Goal",

            options = ProfileOptions.fitnessGoals,

            onValueChange = viewModel::updateFitnessGoal

        )

        FitnessDropdown(

            value = experienceLevel,

            label = "Experience",

            options = ProfileOptions.experienceLevels,

            onValueChange = viewModel::updateExperienceLevel

        )

        FitnessDropdown(

            value = workoutLocation,

            label = "Workout Location",

            options = ProfileOptions.workoutLocations,

            onValueChange = viewModel::updateWorkoutLocation

        )

    }

}