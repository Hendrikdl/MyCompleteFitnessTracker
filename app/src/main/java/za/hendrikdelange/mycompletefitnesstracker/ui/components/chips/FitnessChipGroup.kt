package za.hendrikdelange.mycompletefitnesstracker.ui.components.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.FitnessChip
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessChipGroup(

    title: String,

    chips: List<String>,

    chipColor: Color = FitnessDesign.colors.Primary

) {

    if (chips.isEmpty()) return

    Column(

        modifier = Modifier.fillMaxWidth(),

        verticalArrangement = Arrangement.spacedBy(
            FitnessDesign.spacing.Small
        )

    ) {

        Text(

            text = title,

            style = FitnessDesign.typography.Title,

            color = FitnessDesign.colors.Primary

        )

        FlowRow(

            horizontalArrangement = Arrangement.spacedBy(
                FitnessDesign.spacing.Small
            ),

            verticalArrangement = Arrangement.spacedBy(
                FitnessDesign.spacing.Small
            )

        ) {

            chips.forEach { chip ->

                FitnessChip(

                    text = chip,
                    color = chipColor

                )

            }

        }

    }

}