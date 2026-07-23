package za.hendrikdelange.mycompletefitnesstracker.ui.components.display

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign
import za.hendrikdelange.mycompletefitnesstracker.utils.toDayColor
import za.hendrikdelange.mycompletefitnesstracker.utils.toDayName

@Composable
fun DayIndicator(

    dayOfWeek: Int

) {

    Row(

        verticalAlignment = Alignment.CenterVertically

    ) {

        Box(

            modifier = Modifier
                .size(10.dp)
                .background(
                    dayOfWeek.toDayColor(),
                    CircleShape
                )

        )

        Spacer(
            modifier = Modifier.size(8.dp)
        )

        Text(

            text = dayOfWeek.toDayName(),

            style = FitnessDesign.typography.BodyMedium,

            color = FitnessDesign.colors.TextPrimary

        )

    }

}