package za.hendrikdelange.mycompletefitnesstracker.ui.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun FitnessPickerField(
    value: String,
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedCard(

        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            }

    ) {

        Text(

            text = label,

            style = MaterialTheme.typography.labelMedium,

            color = FitnessDesign.colors.TextSecondary,

            modifier = Modifier.padding(
                start = 16.dp,
                top = 12.dp,
                end = 16.dp
            )

        )

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            horizontalArrangement = Arrangement.SpaceBetween,

            verticalAlignment = Alignment.CenterVertically

        ) {

            Text(

                text =
                    if (value.isBlank())
                        "Select..."
                    else
                        value,

                color =
                    if (value.isBlank())
                        FitnessDesign.colors.TextSecondary
                    else
                        FitnessDesign.colors.TextPrimary

            )

            Icon(

                imageVector = icon,

                contentDescription = null,

                tint = FitnessDesign.colors.Primary

            )

        }

    }

}