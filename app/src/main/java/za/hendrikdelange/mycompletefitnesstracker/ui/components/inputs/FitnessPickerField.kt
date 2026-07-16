package za.hendrikdelange.mycompletefitnesstracker.ui.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessPickerField(
    value: String,
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(

        value = value,

        onValueChange = {},

        readOnly = true,

        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },

        label = {
            Text(label)
        },

        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },

        placeholder = {
            Text("Select...")
        },

        colors = OutlinedTextFieldDefaults.colors(

            focusedTextColor = FitnessDesign.colors.TextPrimary,
            unfocusedTextColor = FitnessDesign.colors.TextPrimary,

            focusedContainerColor = FitnessDesign.colors.Card,
            unfocusedContainerColor = FitnessDesign.colors.Card,

            focusedBorderColor = FitnessDesign.colors.Primary,
            unfocusedBorderColor = FitnessDesign.colors.Border,

            focusedLabelColor = FitnessDesign.colors.Primary,
            unfocusedLabelColor = FitnessDesign.colors.TextSecondary,

            cursorColor = FitnessDesign.colors.Primary

        )

    )

}