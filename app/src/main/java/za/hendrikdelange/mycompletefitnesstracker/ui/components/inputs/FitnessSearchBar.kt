package za.hendrikdelange.mycompletefitnesstracker.ui.components.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun FitnessSearchBar(

    value: String,

    onValueChange: (String) -> Unit,

    modifier: Modifier = Modifier,

    placeholder: String = "Search exercises..."

) {

    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier = modifier.fillMaxWidth(),

        singleLine = true,

        placeholder = {

            Text(placeholder)

        },

        leadingIcon = {

            Icon(

                imageVector = Icons.Default.Search,

                contentDescription = null

            )

        },

        trailingIcon = {

            if (value.isNotBlank()) {

                IconButton(

                    onClick = {

                        onValueChange("")

                    }

                ) {

                    Icon(

                        imageVector = Icons.Default.Clear,

                        contentDescription = "Clear"

                    )

                }

            }

        },

        colors = OutlinedTextFieldDefaults.colors(

            focusedTextColor = FitnessDesign.colors.TextPrimary,

            unfocusedTextColor = FitnessDesign.colors.TextPrimary,

            focusedContainerColor = FitnessDesign.colors.Card,

            unfocusedContainerColor = FitnessDesign.colors.Card,

            focusedBorderColor = FitnessDesign.colors.Primary,

            unfocusedBorderColor = FitnessDesign.colors.Border,

            cursorColor = FitnessDesign.colors.Primary,

            focusedLabelColor = FitnessDesign.colors.Primary,

            unfocusedLabelColor = FitnessDesign.colors.TextSecondary

        )

    )

}