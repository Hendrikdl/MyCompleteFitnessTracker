package za.hendrikdelange.mycompletefitnesstracker.ui.components.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.components.cards.FitnessChip
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun FitnessChipGroup(

    title: String,

    chips: List<String>,

    useAlternatingColors: Boolean = false

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

            chips.forEachIndexed { index, chip ->

                FitnessChip(

                    text = chip,

                    color = if (useAlternatingColors)

                        FitnessDesign.chipColors[
                            index % FitnessDesign.chipColors.size
                        ]

                    else

                        FitnessDesign.colors.Primary

                )

            }

        }

    }

}