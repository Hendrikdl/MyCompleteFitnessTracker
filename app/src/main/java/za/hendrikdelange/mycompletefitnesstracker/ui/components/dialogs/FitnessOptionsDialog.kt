package za.hendrikdelange.mycompletefitnesstracker.ui.components.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import za.hendrikdelange.mycompletefitnesstracker.ui.components.buttons.FitnessButton
import za.hendrikdelange.mycompletefitnesstracker.ui.FitnessTheme.FitnessDesign

@Composable
fun FitnessOptionsDialog(

    title: String,

    onDismiss: () -> Unit,

    onEdit: () -> Unit,

    onDelete: () -> Unit

) {

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {

            Text(

                text = title,

                style = FitnessDesign.typography.Title,

                color = FitnessDesign.colors.Primary

            )

        },

        text = {

            Column(

                verticalArrangement = Arrangement.spacedBy(
                    FitnessDesign.spacing.Small
                )

            ) {

                FitnessButton(
                    text = "Edit",
                    onClick = onEdit

                )

                FitnessButton(
                    text = " 🗑 Delete",
                    onClick = onDelete

                )

            }

        },

        confirmButton = {},

        dismissButton = {

            FitnessButton(
                text = "Cancel",
                onClick = onDismiss

            )

        }

    )

}