package za.hendrikdelange.mycompletefitnesstracker.ui.workouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun WorkoutDetailScreen(

    workoutId: Long

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(FitnessDesign.colors.Background)
            .padding(FitnessDesign.spacing.Large),

        verticalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.Medium
        )

    ) {

        Text(

            text = "Workout ID: $workoutId",

            style = AppTypography.Heading,

            color = FitnessDesign.colors.TextPrimary

        )

        Text(

            text = "No exercises yet.",

            style = AppTypography.Body,

            color = FitnessDesign.colors.TextSecondary

        )

    }

}