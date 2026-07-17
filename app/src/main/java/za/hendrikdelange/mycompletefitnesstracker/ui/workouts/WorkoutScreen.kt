package za.hendrikdelange.mycompletefitnesstracker.ui.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun WorkoutScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(FitnessDesign.colors.Background),
        contentAlignment = Alignment.Center
    ) {
        Text("Workout")
    }
}