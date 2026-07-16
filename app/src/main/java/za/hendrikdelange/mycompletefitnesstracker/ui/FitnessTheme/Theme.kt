package za.hendrikdelange.mycompletefitnesstracker.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun FitnessTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        content = content
    )

}

object FitnessDesign {

    val colors = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
    val spacing = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Spacing
    val shapes = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Shapes
    val typography = za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography

}