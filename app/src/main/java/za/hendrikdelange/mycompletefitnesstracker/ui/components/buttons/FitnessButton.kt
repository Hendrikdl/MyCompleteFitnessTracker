package za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Colors
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.Shapes

@Composable
fun FitnessButton(

    text: String,

    onClick: () -> Unit,

    modifier: Modifier = Modifier,

    enabled: Boolean = true

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

        Text(

            text = text,

            style = MaterialTheme.typography.titleMedium

        )

    }

}