package za.hendrikdelange.mycompletefitnesstracker.ui.components.text

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.AppTypography
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Spacing

@Composable
fun FitnessSectionTitle(
    text: String,
    icon: ImageVector? = null
) {
    if (icon != null) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )

        Spacer (
            Modifier.width(Spacing.Small)
        )
    }
    Text(
        text = text,
        style = AppTypography.Heading,
        color = Colors.TextPrimary
    )
}