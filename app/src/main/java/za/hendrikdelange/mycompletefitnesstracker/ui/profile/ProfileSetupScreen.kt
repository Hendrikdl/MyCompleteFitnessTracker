package za.hendrikdelange.mycompletefitnesstracker.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import za.hendrikdelange.mycompletefitnesstracker.viewmodel.ProfileViewModel
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding


@Composable
fun ProfileSetupScreen(
    firebaseUid: String,
    onComplete: () -> Unit
) {
    val viewModel: ProfileViewModel = hiltViewModel()
    var currentStep by remember {
        mutableIntStateOf(1)
    }

    val firstName by viewModel.firstName.collectAsState()
    val surname by viewModel.surname.collectAsState()
    val dateOfBirth by viewModel.dateOfBirth.collectAsState()
    val gender by viewModel.gender.collectAsState()

    val fitnessGoal by viewModel.fitnessGoal.collectAsState()
    val experienceLevel by viewModel.experienceLevel.collectAsState()
    val workoutLocation by viewModel.workoutLocation.collectAsState()

    val heightCm by viewModel.heightCm.collectAsState()
    val weightKg by viewModel.weightKg.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .navigationBarsPadding(),

        horizontalAlignment = Alignment.CenterHorizontally,

    ) {


        ProfileProgress(
            currentStep = currentStep,
            totalSteps = 3
        )
        Box(
            modifier = Modifier.weight(1f)
        ) {
            AnimatedContent(
                targetState = currentStep,
                transitionSpec = {
                    fadeIn() togetherWith fadeOut()
                },
                label = "Profile Wizard"
            ) { step ->

                when (step) {

                    1 -> PersonalStep()

                    2 -> FitnessStep()

                    3 -> MeasurementsStep()

                }

            }
        }

            ProfileNavigation(

                currentStep = currentStep,
                totalSteps = 3,

                canContinue = when (currentStep) {

                    1 -> firstName.isNotBlank() &&
                            surname.isNotBlank() &&
                            dateOfBirth.isNotBlank() &&
                            gender.isNotBlank()

                    2 -> fitnessGoal.isNotBlank() &&
                            experienceLevel.isNotBlank() &&
                            workoutLocation.isNotBlank()

                    else -> heightCm.isNotBlank() &&
                            weightKg.isNotBlank()
                },

                onPrevious = {
                    currentStep--
                },

                onNext = {
                    currentStep++
                },

                onFinish = {

                    viewModel.saveProfile(firebaseUid) {
                        onComplete()
                    }

                }


            )
        }

}