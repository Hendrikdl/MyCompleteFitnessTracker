package za.hendrikdelange.mycompletefitnesstracker.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors.Surface
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessChip(

    text: String,

    color: Color = FitnessDesign.colors.Primary

) {

    Surface(

        color = color,
        shape = RoundedCornerShape(50)

    ) {

        Text(

            text = text,

            modifier = Modifier.padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )

        )

    }

}