package za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Shapes

@Composable
fun FitnessButton(

    onClick: () -> Unit,

    modifier: Modifier = Modifier,

    enabled: Boolean = true,

    content: @Composable () -> Unit

) {

    Button(

        onClick = onClick,

        enabled = enabled,

        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),

        shape = Shapes.Medium,

        colors = ButtonDefaults.buttonColors(

            containerColor = Colors.Primary,

            contentColor = Colors.TextPrimary,

            disabledContainerColor = Colors.Disabled,

            disabledContentColor = Colors.TextSecondary

        )

    ) {
        androidx.compose.material3.ProvideTextStyle(
            value = MaterialTheme.typography.titleMedium
        ) {

            content()

        }
    }
}