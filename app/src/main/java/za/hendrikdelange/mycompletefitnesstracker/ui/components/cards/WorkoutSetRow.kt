package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs.FitnessTextField

@Composable
fun WorkoutSetRow(

    setNumber: Int,

    weight: String,

    reps: String,

    rest: String,

    onWeightChange: (String) -> Unit,

    onRepsChange: (String) -> Unit,

    onRestChange: (String) -> Unit,

    onDelete: () -> Unit

) {
    FitnessCard {

        Column(

            verticalArrangement = Arrangement.spacedBy(
                FitnessDesign.spacing.Small
            )

        ) {
            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween

            ) {

                Text(

                    text = "Set $setNumber",

                    style = FitnessDesign.typography.TitleMedium,

                    color = FitnessDesign.colors.TextPrimary

                )

                IconButton(

                    onClick = onDelete

                ) {

                    Icon(

                        imageVector = Icons.Default.Delete,

                        contentDescription = "Delete Set",

                        tint = FitnessDesign.colors.Error

                    )

                }

            }
        }
    }
}