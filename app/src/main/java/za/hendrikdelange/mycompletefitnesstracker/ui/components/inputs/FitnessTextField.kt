package za.hendrikdelange.mycompletefitnesstracker.ui.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import za.hendrikdelange.mycompletefitnesstracker.ui.theme.FitnessDesign

@Composable
fun FitnessTextField(

    value: String,

    onValueChange: (String) -> Unit,

    label: String,

    modifier: Modifier = Modifier,

    enabled: Boolean = true,

    readOnly: Boolean = false,

    singleLine: Boolean = true,

    isError: Boolean = false,

    supportingText: String? = null,

    keyboardType: KeyboardType = KeyboardType.Text,

) {



    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        label = {

            Text(label)

        },

        modifier = modifier.fillMaxWidth(),

        colors = OutlinedTextFieldDefaults.colors(

            focusedTextColor = FitnessDesign.colors.TextPrimary,

            unfocusedTextColor = FitnessDesign.colors.TextPrimary,

            focusedContainerColor = FitnessDesign.colors.Card,

            unfocusedContainerColor = FitnessDesign.colors.Card,

            cursorColor = FitnessDesign.colors.Primary,

            focusedBorderColor = FitnessDesign.colors.Primary,

            unfocusedBorderColor = FitnessDesign.colors.Border,

            focusedLabelColor = FitnessDesign.colors.Primary,

            unfocusedLabelColor = FitnessDesign.colors.TextSecondary,

            disabledTextColor = FitnessDesign.colors.TextSecondary,

            disabledBorderColor = FitnessDesign.colors.Border,

            disabledLabelColor = FitnessDesign.colors.TextSecondary,

            disabledContainerColor = FitnessDesign.colors.Card,


            ),

        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )

    )

}