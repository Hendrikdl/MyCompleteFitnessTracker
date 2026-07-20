package za.hendrikdelange.mycompletefitnesstracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun FitnessTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        content = content
    )

}

object FitnessDesign {

    val chipColors = listOf(

        Color(0xFF2196F3),   // Blue

        Color(0xFFFF9800),   // Orange

        Color(0xFF9C27B0),   // Purple

        Color(0xFFE91E63)    // Pink
    )

    val colors = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
    val spacing = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Spacing
    val shapes = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Shapes
    val typography = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography

}