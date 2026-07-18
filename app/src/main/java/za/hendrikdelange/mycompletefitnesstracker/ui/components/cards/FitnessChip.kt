package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessChip(

    text: String

) {

    Text(

        text = text,

        modifier = Modifier
            .background(
                FitnessDesign.colors.Primary,
                RoundedCornerShape(50)
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            ),

        color = FitnessDesign.colors.TextPrimary,

        style = FitnessDesign.typography.BodySmall

    )

}