package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.utils.toDayName

@Composable
fun WorkoutHeader(

    workout: WorkoutPlanEntity

) {

    Column(

        verticalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.ExtraSmall
        )

    ) {

        Text(

            text = workout.name,

            style = FitnessDesign.typography.Heading,

            color = FitnessDesign.colors.TextPrimary

        )

        Text(

            text = workout.dayOfWeek.toDayName(),

            style = FitnessDesign.typography.BodySmall,

            color = FitnessDesign.colors.TextSecondary

        )

        FitnessChip(

            text = workout.category

        )

    }

}