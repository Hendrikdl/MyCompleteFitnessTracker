package za.hendrikdelange.mycompletefitnesstracker.ui.exercises

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.ExerciseEntity
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.FitnessCard
import za.hendrikdelange.mycompletefitnesstracker.ui.components.text.FitnessSectionTitle
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun ExerciseCard(

    exercise: ExerciseEntity,
    modifier: Modifier = Modifier,
    onClick: () ->Unit ={}

) {

    FitnessCard(

        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }

    ) {

        FitnessSectionTitle(

            text = exercise.name

        )

        Text(

            text = exercise.muscleGroup ?: "Unknown muscle",

            style = FitnessDesign.typography.Body,

            color = FitnessDesign.colors.TextSecondary

        )

        exercise.equipment?.let {

            Text(

                text = "Equipment: $it",

                style = FitnessDesign.typography.Caption,

                color = FitnessDesign.colors.TextSecondary

            )

        }

    }

}