package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.data.local.entity.WorkoutPlanEntity
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun WorkoutCard(

    workout: WorkoutPlanEntity,

    modifier: Modifier = Modifier,

    onClick: () -> Unit = {}

) {

    FitnessCard(

        modifier = modifier.clickable {
            onClick()
        }

    ) {
        Column(

            verticalArrangement =
                androidx.compose.foundation.layout.Arrangement.spacedBy(
                    FitnessDesign.spacing.ExtraSmall
                )

        ) {

            Text(

                text = workout.name,

                style = FitnessDesign.typography.TitleMedium,

                color = FitnessDesign.colors.TextPrimary

            )

            Text(

                text = workout.category,

                style = FitnessDesign.typography.BodySmall,

                color = FitnessDesign.colors.TextSecondary

            )

        }

    }

}