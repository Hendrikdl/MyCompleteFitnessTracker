package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.ui.components.display.DayIndicator
import za.hendrikdelange.mycompletefitnesstracker.utils.toCategoryColor

@Composable
fun WorkoutHeader(
    modifier: Modifier = Modifier,

    workout: WorkoutPlanEntity,

    exerciseCount: Int

) {

    Column(

        modifier = modifier

    ) {

        Row(

            modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(

                text = workout.name,

                modifier = Modifier.weight(1f),

                style = FitnessDesign.typography.Heading,

                color = FitnessDesign.colors.TextPrimary

            )

            FitnessChip(

                text = workout.category,

                color = workout.category.toCategoryColor()

            )

        }

        Spacer(

            modifier = Modifier.height(
                FitnessDesign.spacing.Small
            )

        )

        Row(

            modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically

        ) {

            DayIndicator(

                dayOfWeek = workout.dayOfWeek

            )

            Spacer(

                modifier = Modifier.weight(1f)

            )

            Text(

                text = if (exerciseCount == 1)
                    "💪 1 exercise"
                else
                    "💪 $exerciseCount exercises",

                style = FitnessDesign.typography.BodyMedium,

                color = FitnessDesign.colors.TextSecondary

            )

        }

    }

}